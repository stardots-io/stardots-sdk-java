package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delete space request parameters
 */
public class DeleteSpaceReq {
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    // Constructors
    public DeleteSpaceReq() {}
    
    public DeleteSpaceReq(String space) {
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
        return "DeleteSpaceReq{" +
                "space='" + space + '\'' +
                '}';
    }
} 