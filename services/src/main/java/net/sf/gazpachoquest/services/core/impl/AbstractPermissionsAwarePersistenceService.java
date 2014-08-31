package net.sf.gazpachoquest.services.core.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.support.Securizable;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.permission.impl.PermissionSpecification;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPermissionsAwarePersistenceService<S extends Securizable<P>, P extends Permission<S>>
        extends AbstractPersistenceService<S> {

    protected AbstractPermissionsAwarePersistenceService(GenericRepository<S> repository) {
        super(repository);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<S> findAll() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer userId = user.getId();
        Integer roleIds[] = toRoleIds(userRepository.getRoles(userId));
        return repository.findAll(new PermissionSpecification<S, P>().canRead(userId, roleIds));
    }

    @Override
    public S save(S entity) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    private Integer[] toRoleIds(List<Role> roles) {
        Integer[] roleIds = new Integer[roles.size()];
        for (int i = 0; i < roleIds.length; i++) {
            roleIds[i] = roles.get(i).getId();
        }
        return roleIds;
    }
}
