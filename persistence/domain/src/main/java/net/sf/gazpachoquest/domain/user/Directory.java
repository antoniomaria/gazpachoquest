package net.sf.gazpachoquest.domain.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.gazpachoquest.domain.permission.DirectoryPermission;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable;

@Entity
public class Directory extends AbstractSecurizable<DirectoryPermission> {

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Directory parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Set<Directory> subdirectories = new HashSet<Directory>();

    @OneToMany(mappedBy = "directory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Set<User> users = new HashSet<User>();

    public Directory() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Directory> getSubdirectories() {
        return Collections.unmodifiableSet(subdirectories);
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public static class Builder {
        private String name;
        private String description;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Directory build() {
            Directory directory = new Directory();
            directory.name = name;
            directory.description = description;
            return directory;
        }
    }
}
