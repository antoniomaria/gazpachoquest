package net.sf.gazpachoquest.domain.support;

import java.util.Set;

public interface Securizable<P extends Persistable> extends Auditable {
    Set<P> getPermissions();
}
