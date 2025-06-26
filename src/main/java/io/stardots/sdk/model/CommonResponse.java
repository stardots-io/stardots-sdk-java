package io.stardots.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common HTTP response body
 * All interface responses maintain a unified data structure
 */
public class CommonResponse {
    
    /**
     * Service response code.
     */
    @JsonProperty("code")
    private int code;
    
    /**
     * Message prompt of the operation result.
     */
    @JsonProperty("message")
    private String message;
    
    /**
     * A unique number for the request, which can be used for troubleshooting.
     */
    @JsonProperty("requestId")
    private String requestId;
    
    /**
     * Indicates whether the business operation is successful.
     */
    @JsonProperty("bool")
    private boolean success;
    
    /**
     * Server millisecond timestamp.
     */
    @JsonProperty("ts")
    private long timestamp;
    
    /**
     * Business data field. This field can be of any data type. For specific data types, please refer to the corresponding interface.
     */
    @JsonProperty("data")
    private Object data;
    
    // Constructors
    public CommonResponse() {}
    
    public CommonResponse(int code, String message, String requestId, boolean success, long timestamp, Object data) {
        this.code = code;
        this.message = message;
        this.requestId = requestId;
        this.success = success;
        this.timestamp = timestamp;
        this.data = data;
    }
    
    // Getters and Setters
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getRequestId() {
        return requestId;
    }
    
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", requestId='" + requestId + '\'' +
                ", success=" + success +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
} 