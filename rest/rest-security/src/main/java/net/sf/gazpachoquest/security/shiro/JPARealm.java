package net.sf.gazpachoquest.security.shiro;

import java.security.SignatureException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.persistence.PersistenceException;

import net.sf.gazpachoquest.domain.support.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.security.support.HMACSignature;
import net.sf.gazpachoquest.services.UserService;

import org.apache.commons.lang3.StringUtils;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JPARealm extends AuthorizingRealm {

    public final static Logger logger = LoggerFactory.getLogger(JPARealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        HmacAuthToken upToken = (HmacAuthToken) token;
        String apiKey = upToken.getApiKey();

        // Null apikey is invalid
        if (apiKey == null) {
            throw new AccountException("API Key is required");
        }
        User example = new User.Builder().apiKey(apiKey).build();
        User user = null;
        String secret = null;
        try {
            user = userService.findOneByExample(example, new SearchParameters().caseSensitive()).orElseThrow(
                    () -> new UnknownAccountException(String.format("No account found for apikey [%s]", apiKey)));

            secret = user.getSecret();
        } catch (PersistenceException e) {
            final String message = "There was a SQL error while authenticating apikey [" + apiKey + "]";
            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        }
        String message = upToken.getMessage();
        String dateUTC = upToken.getDateUTC();

        verifyDate(dateUTC);

        String expectedSignature = upToken.getSignature();
        verifySignature(secret, message, expectedSignature);

        logger.info("Authentication successfully for user {}", user.getFullName());
        return AuthenticationInfoImpl.with().apiKey(apiKey).principal(user).build();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token.getClass().isAssignableFrom(HmacAuthToken.class);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        User user = (User) getAvailablePrincipal(principals);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Role> roles = userService.getRoles(user.getId());
        for (Role role : roles) {
            info.addRole(role.getName());
        }
        Set<Permission<?>> permissions = userService.getPermissions(user.getId());

        for (Permission<?> permission : permissions) {
            info.addStringPermission(permission.getLiteral());
        }
        return info;
    }

    private void verifyDate(String dateUTC) {
        if (StringUtils.isBlank(dateUTC)) {
            logger.debug("Skiping date validation. No date header found in request");
            return;
        }
        LocalDateTime dateTime = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.ENGLISH);
            // SimpleDateFormat sdf = new
            // SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
            // date = sdf.parse(dateUTC);
            dateTime = LocalDateTime.parse(dateUTC, formatter);
            // TODO waiting for common-lang-3.3.1
            // DateFormatUtils.SMTP_DATETIME_FORMAT.parse(dateUTC);
        } catch (DateTimeParseException e) {
            throw new AuthenticationException("Date format invalid");
        }

        LocalDateTime start = LocalDateTime.now().minusMinutes(5);
        LocalDateTime end = LocalDateTime.now().plusMinutes(5);

        if (dateTime.isBefore(start) || dateTime.isAfter(end)) {
            throw new AuthenticationException("Date not valid. Too old or too far in future");
        }
    }

    private void verifySignature(String secret, String message, String expectedSignature) {
        try {
            logger.debug("Verifing signature... signedContent = {}", message);
            String signature = HMACSignature.calculateRFC2104HMAC(message, secret);

            if (!signature.equals(expectedSignature)) {
                throw new AuthenticationException("Message Signature invalid");
            }
        } catch (SignatureException e) {
            throw new AuthenticationException("Errors verifing hmac signature", e);
        }
    }
}
