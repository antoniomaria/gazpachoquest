package net.sf.gazpachoquest.questionnaires.bootstrap;

public enum ConfigurationKey {
    REST_ENDPOINT("gazpachoquest.rest.endpoint");
    private String key;

    ConfigurationKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
