package net.sf.gazpachoquest.filter;

import java.lang.reflect.Method;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
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
		logger.debug("New request received");

		// @SuppressWarnings("rawtypes")
		Class restClass = resourceClass.getServiceClass();
		Method restMethod = resourceClass.getMethodDispatcher()
				.getOperationResourceInfos().iterator().next()
				.getAnnotatedMethod();

		System.out.println("Class:  " + restClass);
		System.out.println("Method: " + restMethod.getName());
		String path = uriInfo.getPath();
		System.out.println("path:  " + path);

		return null;
	}

}
