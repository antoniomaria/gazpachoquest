package net.sf.gazpachoquest.test.jaxrs.support;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class JAXRSServerExecutionListener extends AbstractTestExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(JAXRSServerExecutionListener.class);

    private Server server;

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        JAXRSServerFactoryBean factory = testContext.getApplicationContext().getBean(JAXRSServerFactoryBean.class);
        String basePath = testContext.getApplicationContext().getEnvironment()
                .getProperty("basePath", "http://localhost:9080/api/");
        logger.debug("Creating JAX-RS Server for resource {} under {} ", testContext.getTestClass(), basePath);
        factory.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
        factory.setAddress(basePath);
        server = factory.create();
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        server.start();
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        server.stop();
        server.destroy();
    }
}
