package net.sf.gazpachoquest.security.shiro;

import java.util.Set;

import javax.persistence.PersistenceException;

import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.services.PermissionService;
import net.sf.gazpachoquest.services.RoleService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.Perm;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JPARealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		APIKeyToken upToken = (APIKeyToken) token;
		String apiKey = upToken.getCredentials().toString();

		// Null apikey is invalid
		if (apiKey == null) {
			throw new AccountException(
					"Null apikeys are not allowed by this realm.");
		}
		User example = new User.Builder().apiKey(apiKey).build();
		User user = null;
		try {
			user = userService
					.findOneByExample(example, new SearchParameters());

			if (user == null) {
				throw new UnknownAccountException(
						"No account found for apikey [" + apiKey + "]");
			}

		} catch (PersistenceException e) {
			final String message = "There was a SQL error while authenticating apikey ["
					+ apiKey + "]";
			// Rethrow any SQL errors as an authentication exception
			throw new AuthenticationException(message, e);
		}

		return AuthenticationInfoImpl.with().apiKey(apiKey).principal(user)
				.build();
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token.getClass().isAssignableFrom(APIKeyToken.class);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// null usernames are invalid
		if (principals == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}
		User user = (User) getAvailablePrincipal(principals);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Set<Role> roles = userService.getRoles(user.getId());
		for (Role role : roles) {
			info.addRole(role.getName());
		}
		Set<Permission> permissions = userService.getPermissions(user.getId());

		for (Permission permission : permissions) {
			info.addStringPermission(permission.getLiteral());
		}
		return info;
	}
}
