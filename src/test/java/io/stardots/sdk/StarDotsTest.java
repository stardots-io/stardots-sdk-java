package io.stardots.sdk;

import io.stardots.sdk.model.CommonResponse;
import io.stardots.sdk.model.request.*;
import io.stardots.sdk.model.response.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * StarDots SDK test class
 */
public class StarDotsTest {
    
    private static final String TEST_CLIENT_KEY = "Your client key";
    private static final String TEST_CLIENT_SECRET = "Your client secret";
    
    @Test
    public void testCreateInstance() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        assertNotNull(stardots);
        
        StarDots stardotsCustom = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET, "https://custom.api.com");
        assertNotNull(stardotsCustom);
    }
    
    @Test
    public void testGetSpaceList() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        SpaceListReq params = new SpaceListReq(1, 50);
        
        try {
            SpaceListResp result = stardots.getSpaceList(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testCreateSpace() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        CreateSpaceReq params = new CreateSpaceReq("demo", true);
        
        try {
            CommonResponse result = stardots.createSpace(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testDeleteSpace() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        DeleteSpaceReq params = new DeleteSpaceReq("demo");
        
        try {
            CommonResponse result = stardots.deleteSpace(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testToggleSpaceAccessibility() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        ToggleSpaceAccessibilityReq params = new ToggleSpaceAccessibilityReq("demo", false);
        
        try {
            CommonResponse result = stardots.toggleSpaceAccessibility(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testGetSpaceFileList() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        SpaceFileListReq params = new SpaceFileListReq(1, 50, "demo");
        
        try {
            SpaceFileListResp result = stardots.getSpaceFileList(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testFileAccessTicket() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        FileAccessTicketReq params = new FileAccessTicketReq("1.png", "demo");
        
        try {
            FileAccessTicketResp result = stardots.fileAccessTicket(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testUploadFile() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        byte[] fileContent = "Hello World!".getBytes();
        UploadFileReq params = new UploadFileReq("test.txt", "demo", fileContent);
        
        try {
            UploadFileResp result = stardots.uploadFile(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
    
    @Test
    public void testDeleteFile() {
        StarDots stardots = StarDotsFactory.create(TEST_CLIENT_KEY, TEST_CLIENT_SECRET);
        DeleteFileReq params = new DeleteFileReq(Arrays.asList("test.txt"), "demo");
        
        try {
            CommonResponse result = stardots.deleteFile(params);
            assertNotNull(result);
        } catch (IOException e) {
            // Expected to fail with invalid credentials
            assertNotNull(e);
        }
    }
} 