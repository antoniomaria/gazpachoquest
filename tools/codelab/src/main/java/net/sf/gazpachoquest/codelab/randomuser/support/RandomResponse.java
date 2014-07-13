/*
 * This code has been copied from:
 * https://github.com/aliilyas/RandomUserApiClient
 */
package net.sf.gazpachoquest.codelab.randomuser.support;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ilyas
 */
public class RandomResponse {

    private List<Result> results;

    public RandomResponse() {
        results = new ArrayList<Result>();
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
