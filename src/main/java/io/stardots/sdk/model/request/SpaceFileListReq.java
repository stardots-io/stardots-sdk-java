package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.stardots.sdk.model.PaginationReq;

/**
 * Get space file list request parameters
 */
public class SpaceFileListReq extends PaginationReq {
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    // Constructors
    public SpaceFileListReq() {
        super();
    }
    
    public SpaceFileListReq(Integer page, Integer pageSize, String space) {
        super(page, pageSize);
        this.space = space;
    }
    
    // Getters and Setters
    public String getSpace() {
        return space;
    }
    
    public void setSpace(String space) {
        this.space = space;
    }
    
    @Override
    public String toString() {
        return "SpaceFileListReq{" +
                "space='" + space + '\'' +
                "} " + super.toString();
    }
} 