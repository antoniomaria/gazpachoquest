package net.sf.gazpachoquest.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable_;
import net.sf.gazpachoquest.domain.user.Directory;
import net.sf.gazpachoquest.domain.user.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-18T16:48:29")
@StaticMetamodel(Directory.class)
public class Directory_ extends AbstractSecurizable_ {

    public static volatile SetAttribute<Directory, User> users;
    public static volatile SingularAttribute<Directory, String> description;
    public static volatile SingularAttribute<Directory, String> name;
    public static volatile SingularAttribute<Directory, Directory> parent;
    public static volatile SetAttribute<Directory, Directory> subdirectories;

}