package net.sf.gazpachoquest.questionnaires.util;

public class MyRestClientImpl implements MyRestClient {

    int id;

    public MyRestClientImpl(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
