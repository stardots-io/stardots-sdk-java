package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ToggleSpaceAccessibility space request parameters
 */
public class ToggleSpaceAccessibilityReq {
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    /**
     * Specifies whether the space is publicly accessible. The default value is false.
     */
    @JsonProperty("public")
    private boolean isPublic;
    
    // Constructors
    public ToggleSpaceAccessibilityReq() {}
    
    public ToggleSpaceAccessibilityReq(String space, boolean isPublic) {
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
    
    public boolean isPublic() {
        return isPublic;
    }
    
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    @Override
    public String toString() {
        return "ToggleSpaceAccessibilityReq{" +
                "space='" + space + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
} 