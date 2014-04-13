/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services.user.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.user.RoleRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;
import net.sf.gazpachoquest.types.RoleScope;
import net.sf.gazpachoquest.util.AcronymGenerator;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractPersistenceService<User> implements
		UserService {

	private static final int API_KEY_LENGTH = 15;

	@Autowired
	private RandomTokenGenerator tokenGenerator;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AcronymGenerator acronymGenerator;

	@Autowired
	public UserServiceImpl(final UserRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = false)
	public User save(final User user) {
		User existing = null;
		if (user.isNew()) {
			String apikey = user.getApiKey();
			if (StringUtils.isBlank(apikey)) {
				apikey = tokenGenerator.generate(API_KEY_LENGTH);
				user.setApiKey(apikey);
			}
			String acronym = acronymGenerator.generate(user.getGivenNames(),
					user.getSurname());
			user.setAcronym(acronym);

			existing = repository.save(user);
			Role role = new Role();
			role.setName(acronym);
			role.setScope(RoleScope.USER);
			role.setDescription(String.format("Specific role for %s %s ",
					user.getGivenNames(), user.getSurname()));
			role = roleRepository.save(role);
			user.assignToRole(role);
		} else {
			existing = repository.findOne(user.getId());
			existing.setEmail(user.getEmail());
			existing.setGivenNames(user.getGivenNames());
			existing.setSurname(user.getSurname());

			existing.setPreferedLanguage(user.getPreferedLanguage());
			existing.setGender(user.getGender());
		}
		return existing;
	}

	@Override
	public List<Permission> getPermissions(Integer userId) {
		return ((UserRepository) repository).getPermissions(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Group> getGroups(Integer userId) {
		return ((UserRepository) repository).getGroups(userId);
	}
}
