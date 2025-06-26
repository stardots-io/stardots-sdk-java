package io.stardots.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Paginator request parameters
 */
public class PaginationReq {
    
    /**
     * Page number, default value is 1.
     */
    @JsonProperty("page")
    private Integer page;
    
    /**
     * The number of entries per page ranges from 1 to 100, and the default value is 20.
     */
    @JsonProperty("pageSize")
    private Integer pageSize;
    
    // Constructors
    public PaginationReq() {}
    
    public PaginationReq(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    
    // Getters and Setters
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    @Override
    public String toString() {
        return "PaginationReq{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
} 