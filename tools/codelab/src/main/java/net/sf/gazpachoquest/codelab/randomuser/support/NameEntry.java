/*
 /*
 * This code has been copied from:
 * https://github.com/aliilyas/RandomUserApiClient
 */
package net.sf.gazpachoquest.codelab.randomuser.support;

/**
 * 
 * @author Ilyas
 */
public class NameEntry {

    private String title;
    private String first;
    private String last;

    public NameEntry() {
    }

    public NameEntry(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "NameEntry [title=" + title + ", first=" + first + ", last=" + last + "]";
    }

}
