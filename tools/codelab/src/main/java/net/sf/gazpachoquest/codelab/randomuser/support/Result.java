/*
 * This code has been copied from:
 * https://github.com/aliilyas/RandomUserApiClient
 */package net.sf.gazpachoquest.codelab.randomuser.support;

/**
 * 
 * @author Ilyas
 */
public class Result {

    private RandomUser user;
    private String seed;
    private String version;

    public Result() {
    }

    public Result(RandomUser user, String seed, String version) {
        this.user = user;
        this.seed = seed;
        this.version = version;
    }

    public RandomUser getUser() {
        return user;
    }

    public void setUser(RandomUser user) {
        this.user = user;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
