package io.stardots.sdk.example;

import io.stardots.sdk.*;
import io.stardots.sdk.model.CommonResponse;
import io.stardots.sdk.model.request.*;
import io.stardots.sdk.model.response.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * Basic usage example for StarDots SDK
 */
public class BasicUsageExample {
    
    public static void main(String[] args) {
        // Initialize the SDK
        String clientKey = "Your client key";
        String clientSecret = "Your client secret";
        StarDots stardots = StarDotsFactory.create(clientKey, clientSecret);
        
        try {
            // Get space list
            System.out.println("Getting space list...");
            SpaceListReq spaceListReq = new SpaceListReq(1, 20);
            SpaceListResp spaceList = stardots.getSpaceList(spaceListReq);
            System.out.println("Space list: " + spaceList);
            
            // Create a new space
            System.out.println("Creating new space...");
            CreateSpaceReq createReq = new CreateSpaceReq("my-demo-space", true);
            CommonResponse createResult = stardots.createSpace(createReq);
            System.out.println("Create result: " + createResult);
            
            // Upload a file
            System.out.println("Uploading file...");
            byte[] fileContent = "Hello World! This is a test file.".getBytes();
            UploadFileReq uploadReq = new UploadFileReq("example.txt", "my-demo-space", fileContent);
            UploadFileResp uploadResult = stardots.uploadFile(uploadReq);
            System.out.println("Upload result: " + uploadResult);
            
            // Get file list
            System.out.println("Getting file list...");
            SpaceFileListReq fileListReq = new SpaceFileListReq(1, 10, "my-demo-space");
            SpaceFileListResp fileList = stardots.getSpaceFileList(fileListReq);
            System.out.println("File list: " + fileList);
            
            // Get file access ticket
            System.out.println("Getting file access ticket...");
            FileAccessTicketReq ticketReq = new FileAccessTicketReq("example.txt", "my-demo-space");
            FileAccessTicketResp ticketResult = stardots.fileAccessTicket(ticketReq);
            System.out.println("Ticket result: " + ticketResult);
            
            // Delete file
            System.out.println("Deleting file...");
            DeleteFileReq deleteReq = new DeleteFileReq(Arrays.asList("example.txt"), "my-demo-space");
            CommonResponse deleteResult = stardots.deleteFile(deleteReq);
            System.out.println("Delete result: " + deleteResult);
            
            // Delete space
            System.out.println("Deleting space...");
            DeleteSpaceReq deleteSpaceReq = new DeleteSpaceReq("my-demo-space");
            CommonResponse deleteSpaceResult = stardots.deleteSpace(deleteSpaceReq);
            System.out.println("Delete space result: " + deleteSpaceResult);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 