package net.sf.gazpachoquest.questionnair.support;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.types.RandomizationStrategy;

public interface PageMetadataCreator {

    PageMetadataStructure create(RandomizationStrategy randomizationStrategy, Breadcrumb breadcrumb);
}
