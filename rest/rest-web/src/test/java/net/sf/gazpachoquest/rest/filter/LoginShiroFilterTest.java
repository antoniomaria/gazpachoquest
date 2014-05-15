package net.sf.gazpachoquest.rest.filter;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.support.HMACSignature;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
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
    public void handleRequestTest() throws SignatureException {
        Message message = createMock(Message.class);
        ClassResourceInfo resourceClass = createMock(ClassResourceInfo.class);
        HttpHeaders headers = createMock(HttpHeaders.class);
        UriInfo uriInfo = createMock(UriInfo.class);

        String date = DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date());

        String resource = "/questionnairs/61";
        String method = "GET";
        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        String apiKey = "B868UOHUTKUDWXM";
        String secret = "IQO27YUZO8NJ7RADIK6SJ9BQZNYP4EMO";
        String signature = HMACSignature.calculateRFC2104HMAC(stringToSign, secret);
        String authToken = generateAuth(apiKey, signature);

        expect(message.get(Message.HTTP_REQUEST_METHOD)).andReturn(method);
        expect(headers.getRequestHeader(HttpHeaders.AUTHORIZATION)).andReturn(Arrays.asList(authToken));
        expect(headers.getRequestHeader(HttpHeaders.DATE)).andReturn(Arrays.asList(date));

        expect(uriInfo.getPath()).andReturn(resource.substring(1));

        replay(message, resourceClass, uriInfo, headers);

        loginShiroFilter.setUriInfo(uriInfo);
        loginShiroFilter.setHeaders(headers);
        loginShiroFilter.handleRequest(message, resourceClass);
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
