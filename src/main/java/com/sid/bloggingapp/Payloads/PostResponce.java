package com.sid.bloggingapp.Payloads;

import java.util.List;

public class PostResponce {

    private List<PostDto> content;
    private Integer pageNumber;
    private Integer pageSize;
    private long totalElements;
    private Integer totalPages;
    private Integer nextPageNumber;
    private boolean LastPageNumber;

    public PostResponce(List<PostDto> content, Integer pageNumber, Integer pageSize, long totalElements,
            Integer totalPages, Integer nextPageNumber, boolean lastPageNumber) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.nextPageNumber = nextPageNumber;
        LastPageNumber = lastPageNumber;
    }

    public PostResponce() {
    }

    public List<PostDto> getContent() {
        return content;
    }

    public void setContent(List<PostDto> content) {
        this.content = content;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public boolean isLastPageNumber() {
        return LastPageNumber;
    }

    public void setLastPageNumber(boolean lastPageNumber) {
        LastPageNumber = lastPageNumber;
    }

}
