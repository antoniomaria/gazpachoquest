package net.sf.gazpachoquest.services.core.impl;

import java.util.List;

import net.sf.gazpachoquest.domain.support.IPermission;
import net.sf.gazpachoquest.domain.support.Securizable;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.repository.user.UserRepository;
import net.sf.gazpachoquest.services.permission.impl.PermissionSpecification;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPermissionsAwarePersistenceService<S extends Securizable<P>, P extends IPermission<S>>
        extends AbstractPersistenceService<S> {

    protected AbstractPermissionsAwarePersistenceService(GenericRepository<S> repository) {
        super(repository);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<S> findAll() {
        Integer userId = 1;
        Integer groupIds[] = toGroupIds(userRepository.getGroups(userId));
        return repository.findAll(new PermissionSpecification<S, P>().canRead(userId, groupIds));
    }

    @Override
    public S save(S entity) {
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    private Integer[] toGroupIds(List<Group> groups) {
        Integer[] groupIds = new Integer[groups.size()];
        for (int i = 0; i < groupIds.length; i++) {
            groupIds[i] = groups.get(i).getId();
        }
        return groupIds;
    }
}
