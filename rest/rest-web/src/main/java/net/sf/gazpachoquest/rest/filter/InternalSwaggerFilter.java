package net.sf.gazpachoquest.rest.filter;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.ApiDescription;
import com.wordnik.swagger.model.Operation;
import com.wordnik.swagger.model.Parameter;

public class InternalSwaggerFilter implements SwaggerSpecFilter {

    @Override
    public boolean isOperationAllowed(Operation operation, ApiDescription apiDescription,
            Map<String, List<String>> stringListMap, Map<String, String> stringStringMap,
            Map<String, List<String>> stringListMap2) {
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
