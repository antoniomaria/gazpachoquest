package net.sf.gazpachoquest.questionnair.support;

import net.sf.gazpachoquest.domain.support.QuestionnairElement;
import net.sf.gazpachoquest.dto.PageMetadataDTO;

public interface PageMetadataCreator {

    PageMetadataDTO create(QuestionnairElement questionnairElement);
}
