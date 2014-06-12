package net.sf.gazpachoquest.dto;

import java.io.Serializable;

public class PageMetadataDTO implements Serializable {

    private static final long serialVersionUID = -8181067033196617785L;

    private int count;

    private int position;

    public PageMetadataDTO() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PageMetadataDTO [count=" + count + ", position=" + position + "]";
    }

}
