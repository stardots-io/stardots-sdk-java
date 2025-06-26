package io.stardots.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Delete file request parameters
 */
public class DeleteFileReq {
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("filenameList")
    private List<String> filenameList;
    
    /**
     * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
     */
    @JsonProperty("space")
    private String space;
    
    // Constructors
    public DeleteFileReq() {}
    
    public DeleteFileReq(List<String> filenameList, String space) {
        this.filenameList = filenameList;
        this.space = space;
    }
    
    // Getters and Setters
    public List<String> getFilenameList() {
        return filenameList;
    }
    
    public void setFilenameList(List<String> filenameList) {
        this.filenameList = filenameList;
    }
    
    public String getSpace() {
        return space;
    }
    
    public void setSpace(String space) {
        this.space = space;
    }
    
    @Override
    public String toString() {
        return "DeleteFileReq{" +
                "filenameList=" + filenameList +
                ", space='" + space + '\'' +
                '}';
    }
} 