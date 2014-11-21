package net.sf.gazpachoquest.domain.user;

import java.util.Map;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.support.AbstractSecurizable_;
import net.sf.gazpachoquest.domain.user.Directory;
import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.6.0.v20140809-rNA", date="2014-11-20T16:05:48")
@StaticMetamodel(User.class)
public class User_ extends AbstractSecurizable_ {

    public static volatile SingularAttribute<User, Language> preferredLanguage;
    public static volatile SingularAttribute<User, String> apiKey;
    public static volatile SingularAttribute<User, Gender> gender;
    public static volatile SingularAttribute<User, String> givenNames;
    public static volatile SetAttribute<User, Role> roles;
    public static volatile SetAttribute<User, Group> groups;
    public static volatile SingularAttribute<User, String> secret;
    public static volatile SingularAttribute<User, Directory> directory;
    public static volatile SetAttribute<User, Questionnaire> questionnaires;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, Map> attributes;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}