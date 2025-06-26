package io.stardots.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * File information data structure
 */
public class FileInfo {
    
    /**
     * The name of the file.
     */
    @JsonProperty("name")
    private String name;
    
    /**
     * The size of the file in bytes.
     */
    @JsonProperty("byteSize")
    private long byteSize;
    
    /**
     * File size, formatted for readability.
     */
    @JsonProperty("size")
    private String size;
    
    /**
     * The timestamp of the file upload in seconds. The time zone is UTC+8.
     */
    @JsonProperty("uploadedAt")
    private long uploadedAt;
    
    /**
     * The access address of the file. Note that if the accessibility of the space is private, this field value will carry the access ticket, which is valid for 20 seconds.
     */
    @JsonProperty("url")
    private String url;
    
    // Constructors
    public FileInfo() {}
    
    public FileInfo(String name, long byteSize, String size, long uploadedAt, String url) {
        this.name = name;
        this.byteSize = byteSize;
        this.size = size;
        this.uploadedAt = uploadedAt;
        this.url = url;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public long getByteSize() {
        return byteSize;
    }
    
    public void setByteSize(long byteSize) {
        this.byteSize = byteSize;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public long getUploadedAt() {
        return uploadedAt;
    }
    
    public void setUploadedAt(long uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public String toString() {
        return "FileInfo{" +
                "name='" + name + '\'' +
                ", byteSize=" + byteSize +
                ", size='" + size + '\'' +
                ", uploadedAt=" + uploadedAt +
                ", url='" + url + '\'' +
                '}';
    }
} 