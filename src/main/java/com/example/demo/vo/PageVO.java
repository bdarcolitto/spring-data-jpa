package com.example.demo.vo;

import java.util.List;

public class PageVO<T> {

    private List<T> content;
    private int totalPage;
    private long totalElements;

    public PageVO(List<T> content, int totalPage, long totalElements) {
        this.content = content;
        this.totalPage = totalPage;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
