package io.stardots.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Space information data structure
 */
public class SpaceInfo {
    
    /**
     * The name of the space.
     */
    @JsonProperty("name")
    private String name;
    
    /**
     * Whether the accessibility of the space is false.
     */
    @JsonProperty("public")
    private boolean isPublic;
    
    /**
     * The system timestamp in seconds when the space was created. The time zone is UTC+8.
     */
    @JsonProperty("createdAt")
    private long createdAt;
    
    /**
     * The number of files in this space.
     */
    @JsonProperty("fileCount")
    private long fileCount;
    
    // Constructors
    public SpaceInfo() {}
    
    public SpaceInfo(String name, boolean isPublic, long createdAt, long fileCount) {
        this.name = name;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
        this.fileCount = fileCount;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isPublic() {
        return isPublic;
    }
    
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    public long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    
    public long getFileCount() {
        return fileCount;
    }
    
    public void setFileCount(long fileCount) {
        this.fileCount = fileCount;
    }
    
    @Override
    public String toString() {
        return "SpaceInfo{" +
                "name='" + name + '\'' +
                ", isPublic=" + isPublic +
                ", createdAt=" + createdAt +
                ", fileCount=" + fileCount +
                '}';
    }
} 