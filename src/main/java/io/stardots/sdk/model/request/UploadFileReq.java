package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Upload file request parameters
 */
public class UploadFileReq {
    
    /**
     * The name of the file.
     */
    @JsonProperty("filename")
    private String filename;
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    /**
     * The file bytes content
     */
    @JsonProperty("fileContent")
    private byte[] fileContent;
    
    // Constructors
    public UploadFileReq() {}
    
    public UploadFileReq(String filename, String space, byte[] fileContent) {
        this.filename = filename;
        this.space = space;
        this.fileContent = fileContent;
    }
    
    // Getters and Setters
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getSpace() {
        return space;
    }
    
    public void setSpace(String space) {
        this.space = space;
    }
    
    public byte[] getFileContent() {
        return fileContent;
    }
    
    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
    
    @Override
    public String toString() {
        return "UploadFileReq{" +
                "filename='" + filename + '\'' +
                ", space='" + space + '\'' +
                ", fileContent.length=" + (fileContent != null ? fileContent.length : 0) +
                '}';
    }
} 