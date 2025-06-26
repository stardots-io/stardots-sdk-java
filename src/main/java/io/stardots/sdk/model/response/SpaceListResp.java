package io.stardots.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.stardots.sdk.model.CommonResponse;
import io.stardots.sdk.model.SpaceInfo;

import java.util.List;

/**
 * Get space list response data structure
 */
public class SpaceListResp extends CommonResponse {
    
    /**
     * Space list data
     */
    @JsonProperty("data")
    private List<SpaceInfo> data;
    
    // Constructors
    public SpaceListResp() {
        super();
    }
    
    public SpaceListResp(List<SpaceInfo> data) {
        this.data = data;
    }
    
    // Getters and Setters
    public List<SpaceInfo> getData() {
        return data;
    }
    
    public void setData(List<SpaceInfo> data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "SpaceListResp{" +
                "data=" + data +
                "} " + super.toString();
    }
} 