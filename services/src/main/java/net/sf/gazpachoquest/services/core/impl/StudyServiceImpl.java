/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.core.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.MailMessage;
import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.domain.core.embeddables.MailMessageTemplateLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.repository.StudyRepository;
import net.sf.gazpachoquest.repository.user.GroupRepository;
import net.sf.gazpachoquest.repository.user.PermissionRepository;
import net.sf.gazpachoquest.repository.user.RoleRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.StudyService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.EntityType;
import net.sf.gazpachoquest.types.InvitationStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.Perm;
import net.sf.gazpachoquest.types.RoleScope;
import net.sf.gazpachoquest.types.StudyAccessType;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

@Service
public class StudyServiceImpl extends AbstractPersistenceService<Study>
		implements StudyService {

	@Autowired
	private InvitationRepository invitationRepository;

	@Autowired
	private MailMessageRepository mailMessageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private QuestionnairDefinitionRepository questionnairDefinitionRepository;

	@Autowired
	private QuestionnairRepository questionnairRepository;

	@Autowired
	private RandomTokenGenerator tokenGenerator;

	@Autowired
	private VelocityEngineFactoryBean velocityFactory;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	public StudyServiceImpl(final StudyRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = false)
	public Study save(Study study) {
		Study existing = null;
		if (study.isNew()) {
			existing = repository.save(study);
		} else {
			existing = repository.findOne(study.getId());
			existing.setStartDate(study.getStartDate());
			existing.setExpirationDate(study.getExpirationDate());
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = false)
	public Study save(Study study,
			Set<QuestionnairDefinition> questionnairDefinitions,
			Set<User> respondents) {
		study = this.save(study);
		if (StudyAccessType.BY_INVITATION.equals(study.getType())) {
			for (QuestionnairDefinition questionnairDefinition : questionnairDefinitions) {

				questionnairDefinition = questionnairDefinitionRepository
						.findOne(questionnairDefinition.getId());

				Map<MailMessageTemplateType, MailMessageTemplate> templates = questionnairDefinition
						.getMailTemplates();
				MailMessageTemplate invitationTemplate = templates
						.get(MailMessageTemplateType.INVITATION);

				Group example = Group.with().name("Respondents").build();
				Group respondentsGroup = groupRepository.findOneByExample(
						example, new SearchParameters());
				for (User respondent : respondents) {
					Assert.state(!respondent.isNew(),
							"Persist all respondents before starting a study.");
					Questionnair questionnair = Questionnair.with()
							.status(EntityStatus.CONFIRMED).study(study)
							.questionnairDefinition(questionnairDefinition)
							.respondent(respondent).build();
					questionnair = questionnairRepository.save(questionnair);

					String token = tokenGenerator.generate();

					respondent = userRepository.findOne(respondent.getId());

					Role personalRole = findOrCreateBy(respondent);

					Permission permission = Permission.with()
							.addPerm(Perm.READ).addPerm(Perm.UPDATE)
							.scope(EntityType.QUESTIONNAIR)
							.entityId(questionnair.getId()).build();

					permissionRepository.save(permission);
					personalRole.assignPermission(permission);

					PersonalInvitation personalInvitation = PersonalInvitation
							.with().study(study).token(token)
							.status(InvitationStatus.ACTIVE)
							.respondent(respondent).build();
					invitationRepository.save(personalInvitation);

					MailMessage mailMessage = composeMailMessage(
							invitationTemplate, respondent, token);
					mailMessageRepository.save(mailMessage);

					if (groupRepository.isUserInGroup(respondent.getId(),
							"Respondents") == 0) {
						respondentsGroup.assignUser(respondent);
					}
				}
			}
		} else {
			Assert.notEmpty(questionnairDefinitions,
					"questionnairDefinitions required");
			Assert.state(questionnairDefinitions.size() == 1,
					"Only one questionnairDefinitions supported for Open Access studies");
			String token = tokenGenerator.generate();

			AnonymousInvitation anonymousInvitation = AnonymousInvitation
					.with().study(study).token(token)
					.status(InvitationStatus.ACTIVE).build();
			invitationRepository.save(anonymousInvitation);
		}
		return study;
	}

	private Role findOrCreateBy(User user) {
		Role example = Role.with().name(user.getAcronym()).build();
		Role role = roleRepository.findOneByExample(example,
				new SearchParameters());
		if (role == null) {
			role = Role
					.with()
					.name(user.getAcronym())
					.scope(RoleScope.USER)
					.description(
							String.format("Specific role for %s %s ",
									user.getGivenNames(), user.getSurname()))
					.build();
			role = roleRepository.save(role);
			user.assignToRole(role);
		}
		return role;
	}

	private MailMessage composeMailMessage(
			final MailMessageTemplate mailMessageTemplate,
			final User respondent, final String surveyLinkToken) {

		Map<String, Object> model = new HashMap<>();
		model.put("lastname",
				StringUtils.defaultIfBlank(respondent.getSurname(), ""));
		model.put("firstname",
				StringUtils.defaultIfBlank(respondent.getGivenNames(), ""));
		model.put("gender", respondent.getGender());
		model.put("link", "http://localhost:8080/questionaires-ui/token="
				+ surveyLinkToken);

		Language preferedLanguage = respondent.getPreferedLanguage();

		StringBuilder templateLocation = new StringBuilder()
				.append(mailMessageTemplate.getId());
		if (preferedLanguage != null) {
			templateLocation.append("/");
			templateLocation.append(preferedLanguage);
		}
		VelocityEngine velocityEngine = velocityFactory.getObject();

		String body = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, templateLocation.toString(), "UTF-8", model);

		MailMessageTemplateLanguageSettings languageSettings = mailMessageTemplate
				.getLanguageSettings();
		if (preferedLanguage != null
				&& !preferedLanguage.equals(mailMessageTemplate.getLanguage())) {
			MailMessageTemplateTranslation preferedTranslation = mailMessageTemplate
					.getTranslations().get(preferedLanguage);
			if (preferedTranslation != null) {
				languageSettings = preferedTranslation.getLanguageSettings();
			}
		}
		MailMessage mailMessage = MailMessage.with()
				.subject(languageSettings.getSubject())
				.to(respondent.getEmail())
				.replyTo(mailMessageTemplate.getReplyTo())
				.from(mailMessageTemplate.getFromAddress()).text(body).build();
		return mailMessage;
	}

}
