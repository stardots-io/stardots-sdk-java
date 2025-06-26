package io.stardots.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.stardots.sdk.model.CommonResponse;
import io.stardots.sdk.model.request.*;
import io.stardots.sdk.model.response.*;
import io.stardots.sdk.util.HttpHelper;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * StarDots SDK interface
 */
public interface StarDots {
    
    /**
     * Get space list data.
     */
    SpaceListResp getSpaceList(SpaceListReq params) throws IOException;
    
    /**
     * Create a new space.
     */
    CommonResponse createSpace(CreateSpaceReq params) throws IOException;
    
    /**
     * Delete an existing space. Note that you must ensure that there are no files in this space, otherwise the deletion will fail.
     */
    CommonResponse deleteSpace(DeleteSpaceReq params) throws IOException;
    
    /**
     * Toggle the accessibility of a space.
     */
    CommonResponse toggleSpaceAccessibility(ToggleSpaceAccessibilityReq params) throws IOException;
    
    /**
     * Get the list of files in the space. The list is sorted in descending order by file upload time.
     */
    SpaceFileListResp getSpaceFileList(SpaceFileListReq params) throws IOException;
    
    /**
     * Get the access ticket for the file. When the accessibility of the space is private, you need to bring the access ticket to access the files under the space, otherwise the request will be rejected.
     */
    FileAccessTicketResp fileAccessTicket(FileAccessTicketReq params) throws IOException;
    
    /**
     * Upload the file to the space. Note that this request requires you to initiate the request in the form of a form.
     */
    UploadFileResp uploadFile(UploadFileReq params) throws IOException;
    
    /**
     * Delete files in the space. This interface supports batch operations.
     */
    CommonResponse deleteFile(DeleteFileReq params) throws IOException;
}

/**
 * StarDots SDK implementation
 */
class StarDotsImpl implements StarDots {
    
    private final String endpoint;
    private final String clientKey;
    private final String clientSecret;
    private final ObjectMapper objectMapper;
    
    public StarDotsImpl(String clientKey, String clientSecret, String endpoint) {
        this.clientKey = clientKey;
        this.clientSecret = clientSecret;
        this.endpoint = endpoint;
        this.objectMapper = new ObjectMapper();
    }
    
    @Override
    public SpaceListResp getSpaceList(SpaceListReq params) throws IOException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(HttpHelper.requestUrl(endpoint, "/openapi/space/list"));
        
        // Add query parameters
        boolean first = true;
        if (params.getPage() != null) {
            urlBuilder.append(first ? "?" : "&").append("page=").append(params.getPage());
            first = false;
        }
        if (params.getPageSize() != null) {
            urlBuilder.append(first ? "?" : "&").append("pageSize=").append(params.getPageSize());
        }
        
        String url = urlBuilder.toString();
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("GET", url, null, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), SpaceListResp.class);
    }
    
    @Override
    public CommonResponse createSpace(CreateSpaceReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/space/create");
        byte[] payload = objectMapper.writeValueAsBytes(params);
        
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("PUT", url, payload, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), CommonResponse.class);
    }
    
    @Override
    public CommonResponse deleteSpace(DeleteSpaceReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/space/delete");
        byte[] payload = objectMapper.writeValueAsBytes(params);
        
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("DELETE", url, payload, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), CommonResponse.class);
    }
    
    @Override
    public CommonResponse toggleSpaceAccessibility(ToggleSpaceAccessibilityReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/space/accessibility/toggle");
        byte[] payload = objectMapper.writeValueAsBytes(params);
        
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("POST", url, payload, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), CommonResponse.class);
    }
    
    @Override
    public SpaceFileListResp getSpaceFileList(SpaceFileListReq params) throws IOException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(HttpHelper.requestUrl(endpoint, "/openapi/file/list"));
        
        // Add query parameters
        boolean first = true;
        if (params.getPage() != null) {
            urlBuilder.append(first ? "?" : "&").append("page=").append(params.getPage());
            first = false;
        }
        if (params.getPageSize() != null) {
            urlBuilder.append(first ? "?" : "&").append("pageSize=").append(params.getPageSize());
            first = false;
        }
        if (params.getSpace() != null) {
            urlBuilder.append(first ? "?" : "&").append("space=").append(URLEncoder.encode(params.getSpace(), StandardCharsets.UTF_8.toString()));
        }
        
        String url = urlBuilder.toString();
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("GET", url, null, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), SpaceFileListResp.class);
    }
    
    @Override
    public FileAccessTicketResp fileAccessTicket(FileAccessTicketReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/file/ticket");
        byte[] payload = objectMapper.writeValueAsBytes(params);
        
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("POST", url, payload, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), FileAccessTicketResp.class);
    }
    
    @Override
    public UploadFileResp uploadFile(UploadFileReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/file/upload");
        
        HttpHelper.HttpResponse response = HttpHelper.sendMultipartRequest(url, 
                HttpHelper.makeHeaders(clientKey, clientSecret), 
                params.getFilename(), params.getFileContent(), params.getSpace());
        
        return objectMapper.readValue(response.getBody(), UploadFileResp.class);
    }
    
    @Override
    public CommonResponse deleteFile(DeleteFileReq params) throws IOException {
        String url = HttpHelper.requestUrl(endpoint, "/openapi/file/delete");
        byte[] payload = objectMapper.writeValueAsBytes(params);
        
        HttpHelper.HttpResponse response = HttpHelper.sendRequest("DELETE", url, payload, 
                HttpHelper.makeHeaders(clientKey, clientSecret), Constants.DEFAULT_REQUEST_TIMEOUT);
        
        return objectMapper.readValue(response.getBody(), CommonResponse.class);
    }
} 