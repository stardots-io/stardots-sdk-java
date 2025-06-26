package io.stardots.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.stardots.sdk.model.CommonResponse;

/**
 * Upload file response data structure
 */
public class UploadFileResp extends CommonResponse {
    
    /**
     * Upload result data wrapper
     */
    public static class UploadData {
        /**
         * The name of the space. It can only be a combination of letters or numbers, and the length is 4 to 15 characters.
         */
        @JsonProperty("space")
        private String space;
        
        /**
         * The name of the file.
         */
        @JsonProperty("filename")
        private String filename;
        
        /**
         * The access address of the file. Note that if the accessibility of the space is private, this field value will carry the access ticket, which is valid for 20 seconds.
         */
        @JsonProperty("url")
        private String url;
        
        public UploadData() {}
        
        public UploadData(String space, String filename, String url) {
            this.space = space;
            this.filename = filename;
            this.url = url;
        }
        
        public String getSpace() {
            return space;
        }
        
        public void setSpace(String space) {
            this.space = space;
        }
        
        public String getFilename() {
            return filename;
        }
        
        public void setFilename(String filename) {
            this.filename = filename;
        }
        
        public String getUrl() {
            return url;
        }
        
        public void setUrl(String url) {
            this.url = url;
        }
        
        @Override
        public String toString() {
            return "UploadData{" +
                    "space='" + space + '\'' +
                    ", filename='" + filename + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
    
    /**
     * Upload data
     */
    @JsonProperty("data")
    private UploadData data;
    
    // Constructors
    public UploadFileResp() {
        super();
    }
    
    public UploadFileResp(UploadData data) {
        this.data = data;
    }
    
    // Getters and Setters
    public UploadData getData() {
        return data;
    }
    
    public void setData(UploadData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "UploadFileResp{" +
                "data=" + data +
                "} " + super.toString();
    }
} 