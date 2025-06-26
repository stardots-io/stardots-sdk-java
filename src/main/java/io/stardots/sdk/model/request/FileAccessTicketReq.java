package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Get file access ticket request parameters
 */
public class FileAccessTicketReq {
    
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
    
    // Constructors
    public FileAccessTicketReq() {}
    
    public FileAccessTicketReq(String filename, String space) {
        this.filename = filename;
        this.space = space;
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
    
    @Override
    public String toString() {
        return "FileAccessTicketReq{" +
                "filename='" + filename + '\'' +
                ", space='" + space + '\'' +
                '}';
    }
} 