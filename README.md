<div align="center">
    <h1><img src="logo.png" alt="logo.png" title="logo.png" width="300" /></h1>
</div> 

# StarDots-SDK-Java  

[![Java](https://img.shields.io/badge/Java-8+-green.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-orange.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)  

### Introduction  
This project is used to help developers quickly access the StarDots platform and is written in Java 8.  

### Requirement  
> Java version >= 1.8  

### Installation  

#### Maven
Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.stardots</groupId>
    <artifactId>stardots-sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle
Add the following dependency to your `build.gradle`:

```gradle
implementation 'io.stardots:stardots-sdk-java:1.0.0'
```

### Example  
```java 
import io.stardots.sdk.*;

// Initialize the SDK
String clientKey = "Your client key";  
String clientSecret = "Your client secret";  
StarDots stardots = StarDotsFactory.create(clientKey, clientSecret);

// Get space list
SpaceListReq spaceListReq = new SpaceListReq(1, 20);
SpaceListResp spaceList = stardots.getSpaceList(spaceListReq);

// Create a new space
CreateSpaceReq createReq = new CreateSpaceReq("my-space", true);
CommonResponse createResult = stardots.createSpace(createReq);

// Upload a file
byte[] fileContent = "Hello World!".getBytes();
UploadFileReq uploadReq = new UploadFileReq("example.txt", "my-space", fileContent);
UploadFileResp uploadResult = stardots.uploadFile(uploadReq);
```  

### API Reference

#### Constructor
```java
StarDotsFactory.create(String clientKey, String clientSecret)
StarDotsFactory.create(String clientKey, String clientSecret, String endpoint)
```

#### Methods
- `getSpaceList(SpaceListReq params)` - Get space list data
- `createSpace(CreateSpaceReq params)` - Create a new space
- `deleteSpace(DeleteSpaceReq params)` - Delete an existing space
- `toggleSpaceAccessibility(ToggleSpaceAccessibilityReq params)` - Toggle space accessibility
- `getSpaceFileList(SpaceFileListReq params)` - Get space file list
- `fileAccessTicket(FileAccessTicketReq params)` - Get file access ticket
- `uploadFile(UploadFileReq params)` - Upload file to space
- `deleteFile(DeleteFileReq params)` - Delete files from space

### Dependencies
- Jackson 2.15.2 - JSON processing
- OkHttp 4.11.0 - HTTP client
- JUnit 4.13.2 - Testing (test scope)

### Documentation  
[https://stardots.io/en/documentation/openapi](https://stardots.io/en/documentation/openapi)  

### Homepage  
[https://stardots.io](https://stardots.io) 