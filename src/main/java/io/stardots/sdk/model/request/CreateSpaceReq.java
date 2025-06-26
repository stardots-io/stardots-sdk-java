package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Create space request parameters
 */
public class CreateSpaceReq {
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    /**
     * Specifies whether the space is publicly accessible. The default value is false.
     */
    @JsonProperty("public")
    private Boolean isPublic;
    
    // Constructors
    public CreateSpaceReq() {}
    
    public CreateSpaceReq(String space, Boolean isPublic) {
        this.space = space;
        this.isPublic = isPublic;
    }
    
    // Getters and Setters
    public String getSpace() {
        return space;
    }
    
    public void setSpace(String space) {
        this.space = space;
    }
    
    public Boolean getIsPublic() {
        return isPublic;
    }
    
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    @Override
    public String toString() {
        return "CreateSpaceReq{" +
                "space='" + space + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
} 