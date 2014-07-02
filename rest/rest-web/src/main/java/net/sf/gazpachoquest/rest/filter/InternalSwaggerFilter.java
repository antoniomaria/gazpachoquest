package net.sf.gazpachoquest.rest.filter;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.ApiDescription;
import com.wordnik.swagger.model.Operation;
import com.wordnik.swagger.model.Parameter;

public class InternalSwaggerFilter implements SwaggerSpecFilter {

    private static final Logger logger = LoggerFactory.getLogger(InternalSwaggerFilter.class);

    public InternalSwaggerFilter() {
        logger.info("Internal Swagger Filter initialized");
    }

    @Override
    public boolean isOperationAllowed(Operation operation, ApiDescription apiDescription,
            Map<String, List<String>> stringListMap, Map<String, String> stringStringMap,
            Map<String, List<String>> stringListMap2) {
        // FilterFactory.setFilter(new InternalSwaggerFilter());
        return true;
    }

    @Override
    public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription apiDescription,
            Map<String, List<String>> stringListMap, Map<String, String> stringStringMap,
            Map<String, List<String>> stringListMap2) {
        if (parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")) {
            return false;
        }
        return true;
    }
}
