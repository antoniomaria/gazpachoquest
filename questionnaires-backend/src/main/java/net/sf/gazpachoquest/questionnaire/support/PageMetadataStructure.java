package net.sf.gazpachoquest.questionnaire.support;


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

    public boolean isLast() {
        return number == count;
    }

    public boolean isNotLast() {
        return number != count;
    }

    public boolean isFirst() {
        return number == 1;
    }

    public boolean isNotFirst() {
        return number != 1;
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
