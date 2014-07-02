package net.sf.gazpachoquest.rest.support;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Provider
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

    private ObjectMapper mapper = new ObjectMapper();

    public JacksonConfigurator() {/*-
                                  SerializationConfig serConfig = mapper.getSerializationConfig();
                                  serConfig.setDateFormat(DateFormatUtils.SMTP_DATETIME_FORMAT);
                                  DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
                                  deserializationConfig.setDateFormat(DateFormatUtils.SMTP_DATETIME_FORMAT);*/
        /* Register JodaModule to handle Joda DateTime Objects. */
        mapper.registerModule(new JodaModule());
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        
        SerializationConfig config = mapper.getSerializationConfig();
        config.withSerializationInclusion(Include.NON_EMPTY);
      //  mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // https://github.com/FasterXML/jackson-datatype-joda
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }
}
