package net.sf.gazpachoquest.rest.filter;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.io.IOException;
import java.net.URI;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.support.HMACSignature;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/rest-security-context.xml", })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LoginShiroFilterTest-dataset.xml")
@DatabaseTearDown("LoginShiroFilterTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class LoginShiroFilterTest {

    private LoginShiroFilter loginShiroFilter;

    @Before
    public void setUp() {
        loginShiroFilter = new LoginShiroFilter();
    }

    @Test
    public void handleRequestTest() throws SignatureException, IOException {
        ContainerRequestContext requestContext = createMock(ContainerRequestContext.class);
        ClassResourceInfo resourceClass = createMock(ClassResourceInfo.class);
        HttpHeaders headers = createMock(HttpHeaders.class);
        UriInfo uriInfo = createMock(UriInfo.class);

        String date = DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date());

        String resource = "/questionnaires/61";
        String method = "GET";
        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        String apiKey = "B868UOHUTKUDWXM";
        
        String secret = "IQO27YUZO8NJ7RADIK6SJ9BQZNYP4EMO";
        String signature = HMACSignature.calculateRFC2104HMAC(stringToSign, secret);
        String authToken = generateAuth(apiKey, signature);

        expect(requestContext.getMethod()).andReturn(method);
        expect(uriInfo.getRequestUri()).andReturn(URI.create("http://localhost:8080/gazpachoquest-rest-web/api/" + resource));
        
        expect(requestContext.getHeaderString(HttpHeaders.AUTHORIZATION)).andReturn(authToken);
        expect(requestContext.getHeaderString(HttpHeaders.DATE)).andReturn(date);
        
        expect(headers.getRequestHeader(HttpHeaders.AUTHORIZATION)).andReturn(Arrays.asList(authToken));
        expect(headers.getRequestHeader(HttpHeaders.DATE)).andReturn(Arrays.asList(date));

        expect(uriInfo.getPath()).andReturn(resource.substring(1));

        replay(requestContext,resourceClass, uriInfo, headers);

        loginShiroFilter.setUriInfo(uriInfo);
        loginShiroFilter.setHeaders(headers);

        loginShiroFilter.filter(requestContext);
    }

    public String generateAuth(String apiKey, String signature) {
        StringBuilder auth = new StringBuilder();
        auth.append("hmac ");
        auth.append(apiKey);
        auth.append(":");
        auth.append(signature);
        return auth.toString();
    }

}
