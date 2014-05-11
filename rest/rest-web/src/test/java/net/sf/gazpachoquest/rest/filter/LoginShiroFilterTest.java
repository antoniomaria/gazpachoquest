package net.sf.gazpachoquest.rest.filter;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.Arrays;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.junit.Before;
import org.junit.Test;

public class LoginShiroFilterTest {

    private LoginShiroFilter loginShiroFilter;

    @Before
    public void setUp() {
        this.loginShiroFilter = new LoginShiroFilter();
    }

    @Test
    public void handleRequestTest() {
        Message message = createMock(Message.class);
        ClassResourceInfo resourceClass = createMock(ClassResourceInfo.class);
        HttpHeaders headers = createMock(HttpHeaders.class);
        UriInfo uriInfo = createMock(UriInfo.class);

        expect(message.get(Message.HTTP_REQUEST_METHOD)).andReturn("GET");

        expect(headers.getRequestHeader(HttpHeaders.AUTHORIZATION)).andReturn(
                Arrays.asList("hmac 1234:HPcE6oKQgchCWKKm+ntPPQ4hEqE="));
        expect(headers.getRequestHeader(HttpHeaders.DATE)).andReturn(Arrays.asList("Sun, 11 May 2014 10:11:07 +0200"));

        expect(uriInfo.getPath()).andReturn("questionnairs/11/answer");

        replay(message, resourceClass, uriInfo, headers);

        loginShiroFilter.setUriInfo(uriInfo);
        loginShiroFilter.setHeaders(headers);
        loginShiroFilter.handleRequest(message, resourceClass);
    }
}
