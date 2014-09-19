package net.sf.gazpachoquest.services.user.impl;

import net.sf.gazpachoquest.domain.permission.DirectoryPermission;
import net.sf.gazpachoquest.domain.user.Directory;
import net.sf.gazpachoquest.repository.permission.DirectoryPermissionRepository;
import net.sf.gazpachoquest.repository.user.DirectoryRepository;
import net.sf.gazpachoquest.services.DirectoryService;
import net.sf.gazpachoquest.services.core.impl.AbstractPersistenceService;
import net.sf.gazpachoquest.types.Perm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DirectoryServiceImpl extends AbstractPersistenceService<Directory> implements DirectoryService {

    @Autowired
    private DirectoryPermissionRepository directoryPermissionRepository;

    @Autowired
    public DirectoryServiceImpl(final DirectoryRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Directory save(final Directory directory) {
        Directory existing = null;
        if (directory.isNew()) {
            existing = repository.save(directory);

            DirectoryPermission permission = DirectoryPermission.with().addPerm(Perm.READ).addPerm(Perm.UPDATE)
                    .addPerm(Perm.DELETE).target(existing).user(getAuthenticatedUser()).build();
            directoryPermissionRepository.save(permission);
        } else {
            existing = repository.findOne(directory.getId());
            existing.setName(directory.getName());
            existing.setDescription(directory.getDescription());
        }
        return existing;
    }

}
