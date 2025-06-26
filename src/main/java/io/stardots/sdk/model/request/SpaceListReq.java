package io.stardots.sdk.model.request;

import io.stardots.sdk.model.PaginationReq;

/**
 * Get space list request parameters
 */
public class SpaceListReq extends PaginationReq {
    
    // Constructors
    public SpaceListReq() {
        super();
    }
    
    public SpaceListReq(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
} 