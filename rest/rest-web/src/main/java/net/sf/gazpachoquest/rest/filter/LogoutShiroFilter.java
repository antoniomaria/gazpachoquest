package net.sf.gazpachoquest.rest.filter;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.ResponseHandler;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.message.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class LogoutShiroFilter implements ResponseHandler {

    @Override
    public Response handleResponse(Message m, OperationResourceInfo ori, Response response) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return null;
    }

}
