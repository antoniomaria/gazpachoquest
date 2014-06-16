package net.sf.gazpachoquest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageMetadataDTO implements Serializable {

    private static final long serialVersionUID = -8181067033196617785L;

    private int count;

    private int number;

    public PageMetadataDTO() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int position) {
        number = position;
    }

    @JsonIgnore
    public boolean isLast() {
        return number == count;
    }

    @JsonIgnore
    public boolean isNotLast() {
        return number != count;
    }

    @JsonIgnore
    public boolean isFirst() {
        return number == 1;
    }

    @JsonIgnore
    public boolean isNotFirst() {
        return number != 1;
    }

    @Override
    public String toString() {
        return "PageMetadataDTO [count=" + count + ", number=" + number + "]";
    }

}
