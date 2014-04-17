package net.sf.gazpachoquest.rest.filter;

import java.lang.reflect.Method;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.rest.resources.AuthenticationResource;
import net.sf.gazpachoquest.security.shiro.APIKeyToken;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// https://github.com/Talend/tsf/blob/master/examples/jaxrs-oauth/service/src/main/java/oauth/thirdparty/SecurityContextFilter.java
// @Provider

public class SecurityContextFilter implements RequestHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(SecurityContextFilter.class);

	@Context
	private HttpHeaders headers;

	@Context
	UriInfo uriInfo;

	@Override
	public Response handleRequest(Message message,
			ClassResourceInfo resourceClass) {
		String path = uriInfo.getPath();
		logger.debug("New access to resource {}",path );
		
		if (path.startsWith("auth") || path.contains("api-docs") ){
			// Ignore the AuthenticationResource
			return null;
		}

		String apiKey = !headers.getRequestHeader("api_key").isEmpty() ? headers.getRequestHeader("api_key").get(0) : null;

		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new APIKeyToken.Builder().apiKey(
				apiKey).build();
		subject.login(token); // 
		return null;
	}

}
