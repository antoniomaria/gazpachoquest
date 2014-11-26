package net.sf.gazpachoquest.rest.support;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonContextResolver() {
        /*
         * Register JodaModule to handle Joda DateTime Objects.
         * https://github.com/FasterXML/jackson-datatype-jsr310
         */
        mapper.registerModule(new JSR310Module());
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }
}
