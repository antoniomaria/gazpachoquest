package net.sf.gazpachoquest.rest.feature;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class Jackson2Feature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.register(provider);
        return true;
    }

    private static final ObjectMapper mapper = new ObjectMapper() {
        private static final long serialVersionUID = 1427022268405277021L;
        {
            // registerModule(new JodaModule());
            // registerModule(new GuavaModule()); // or whatever you want...
            // We want ISO dates, not Unix timestamps!:
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
    };

    private static final JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider() {
        {
            setMapper(mapper);
        }
    };
}
