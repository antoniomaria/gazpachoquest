package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.MailMessageTemplate;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.facades.MailMessageFacade;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailMessageFacadeImpl implements MailMessageFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    public MailMessageFacadeImpl() {
        super();
    }

    @Override
    public MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate) {
        MailMessageTemplate entity = mapper.map(mailMessageTemplate, MailMessageTemplate.class);
        entity = mailMessageTemplateService.save(entity);
        return mapper.map(entity, MailMessageTemplateDTO.class);
    }
}
