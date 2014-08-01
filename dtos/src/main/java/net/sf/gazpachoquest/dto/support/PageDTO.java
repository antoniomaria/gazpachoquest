package net.sf.gazpachoquest.dto.support;

import java.util.ArrayList;
import java.util.List;

public class PageDTO<T extends Identifiable> {

    private Integer totalPages;

    private Long totalElements;

    private List<T> elements = new ArrayList<>();

    private Integer number;

    private Integer size;

    public PageDTO() {
        super();
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> content) {
        this.elements = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void addElement(T element) {
        this.elements.add(element);
    }
}
