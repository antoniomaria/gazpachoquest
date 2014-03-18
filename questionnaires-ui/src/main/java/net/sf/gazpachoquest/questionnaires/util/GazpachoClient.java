package net.sf.gazpachoquest.questionnaires.util;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
// @Target({ FIELD, TYPE, METHOD })
@Target({ ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
public @interface GazpachoClient {

}
