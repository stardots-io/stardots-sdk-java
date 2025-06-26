package io.stardots.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.stardots.sdk.model.CommonResponse;
import io.stardots.sdk.model.FileInfo;

import java.util.List;

/**
 * Get space file list response data structure
 */
public class SpaceFileListResp extends CommonResponse {
    
    /**
     * File list data wrapper
     */
    public static class FileListData {
        @JsonProperty("list")
        private List<FileInfo> list;
        
        public FileListData() {}
        
        public FileListData(List<FileInfo> list) {
            this.list = list;
        }
        
        public List<FileInfo> getList() {
            return list;
        }
        
        public void setList(List<FileInfo> list) {
            this.list = list;
        }
        
        @Override
        public String toString() {
            return "FileListData{" +
                    "list=" + list +
                    '}';
        }
    }
    
    /**
     * File list data
     */
    @JsonProperty("data")
    private FileListData data;
    
    // Constructors
    public SpaceFileListResp() {
        super();
    }
    
    public SpaceFileListResp(FileListData data) {
        this.data = data;
    }
    
    // Getters and Setters
    public FileListData getData() {
        return data;
    }
    
    public void setData(FileListData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "SpaceFileListResp{" +
                "data=" + data +
                "} " + super.toString();
    }
} 