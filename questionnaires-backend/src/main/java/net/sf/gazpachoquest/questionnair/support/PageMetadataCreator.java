package net.sf.gazpachoquest.questionnair.support;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

public interface PageMetadataCreator {

    PageMetadataStructure create(RandomizationStrategy randomizationStrategy, RenderingMode type, Breadcrumb breadcrumb);
}
