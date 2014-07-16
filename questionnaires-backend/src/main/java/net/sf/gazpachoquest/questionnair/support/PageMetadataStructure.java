package net.sf.gazpachoquest.questionnair.support;

public class PageMetadataStructure {

    private int count;

    private int number;

    public PageMetadataStructure() {
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

    @Override
    public String toString() {
        return "PageMetadataStructure [count=" + count + ", number=" + number + "]";
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private int count;
        private int number;

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public PageMetadataStructure build() {
            PageMetadataStructure pageMetadataStructure = new PageMetadataStructure();
            pageMetadataStructure.count = count;
            pageMetadataStructure.number = number;
            return pageMetadataStructure;
        }
    }
}
