package net.sf.gazpachoquest.domain.support;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractSecurizable<P extends Persistable> extends AbstractAuditable implements Securizable<P> {

    @OneToMany(mappedBy = "target", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private final Set<P> permissions = new HashSet<P>();

    @Override
    public Set<P> getPermissions() {
        return Collections.unmodifiableSet(permissions);
    }
}
