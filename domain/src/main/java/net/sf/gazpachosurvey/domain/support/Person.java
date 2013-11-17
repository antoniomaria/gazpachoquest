package net.sf.gazpachosurvey.domain.support;

import java.security.Principal;
import java.util.Set;

public interface Person extends Principal {

    Set<String> getRoles();
}
