package net.sf.gazpachoquest.domain.permission;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.IPermission;
import net.sf.gazpachoquest.domain.support.Securizable;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.User;

@MappedSuperclass
public class AbstractPermission<T extends Securizable<?>> extends AbstractPersistable implements IPermission<T> {

    private static final long serialVersionUID = 6599066653542691509L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected Group group;

    protected Integer mask;

    protected T target;

    public AbstractPermission() {
        super();
    }

    public AbstractPermission(User user, Group group, Integer mask, T target) {
        super();
        this.user = user;
        this.group = group;
        this.mask = mask;
        this.target = target;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
