package net.sf.gazpachoquest.services.core.impl;

import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.support.Securizable;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.permission.impl.PermissionSpecification;

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
        Integer userId = getAuthenticatedUser().getId();
        Integer roleIds[] = toRoleIds(userRepository.getRoles(userId));
        return repository.findAll(new PermissionSpecification<S, P>().canRead(userId, roleIds));
    }

    @Override
    public S save(S entity) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    private Integer[] toRoleIds(Set<Role> roles) {
        Integer[] roleIds = new Integer[roles.size()];
        int i = 0;
        for (Role role : roles) {
            roleIds[i++] = role.getId();

        }
        return roleIds;
    }
}
