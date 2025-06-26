package io.stardots.sdk.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.stardots.sdk.Constants;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * HTTP helper utilities
 */
public class HttpHelper {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final OkHttpClient httpClient = createHttpClient();
    
    /**
     * Generate request URL
     */
    public static String requestUrl(String endpoint, String path) {
        return endpoint + path;
    }
    
    /**
     * Generate authentication request headers
     */
    public static Map<String, String> makeHeaders(String clientKey, String clientSecret) {
        long ts = System.currentTimeMillis() / 1000;
        String nonce = System.currentTimeMillis() + String.valueOf(10000 + new Random().nextInt(10000));
        String needSignStr = ts + "|" + clientSecret + "|" + nonce;
        
        String sign = md5(needSignStr).toUpperCase();
        
        Map<String, String> extraInfo = new HashMap<>();
        extraInfo.put("sdk", "true");
        extraInfo.put("language", "java");
        extraInfo.put("version", Constants.SDK_VERSION);
        extraInfo.put("os", System.getProperty("os.name"));
        extraInfo.put("arch", System.getProperty("os.arch"));
        
        String extraInfoJson;
        try {
            extraInfoJson = objectMapper.writeValueAsString(extraInfo);
        } catch (Exception e) {
            extraInfoJson = "{}";
        }
        
        Map<String, String> headers = new HashMap<>();
        headers.put("x-stardots-timestamp", String.valueOf(ts));
        headers.put("x-stardots-nonce", nonce);
        headers.put("x-stardots-key", clientKey);
        headers.put("x-stardots-sign", sign);
        headers.put("x-stardots-extra", extraInfoJson);
        
        return headers;
    }
    
    /**
     * Send HTTP request
     */
    public static HttpResponse sendRequest(String method, String url, byte[] jsonPayload, 
                                         Map<String, String> headers, long timeout) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        
        // Set method and body
        if (jsonPayload != null && jsonPayload.length > 0) {
            RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json; charset=utf-8"));
            requestBuilder.method(method, body);
        } else {
            requestBuilder.method(method, null);
        }
        
        // Set default content type
        requestBuilder.addHeader("Content-Type", "application/json; charset=utf-8");
        
        // Set custom headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        
        Request request = requestBuilder.build();
        
        try (Response response = httpClient.newCall(request).execute()) {
            byte[] responseBody = response.body() != null ? response.body().bytes() : new byte[0];
            return new HttpResponse(responseBody, response.code());
        }
    }
    
    /**
     * Send multipart request for file upload
     */
    public static HttpResponse sendMultipartRequest(String url, Map<String, String> headers,
                                                  String filename, byte[] fileContent, String space) throws IOException {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", filename, 
                        RequestBody.create(fileContent, MediaType.parse("application/octet-stream")))
                .addFormDataPart("space", space);
        
        RequestBody body = bodyBuilder.build();
        
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .put(body);
        
        // Set custom headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        
        Request request = requestBuilder.build();
        
        try (Response response = httpClient.newCall(request).execute()) {
            byte[] responseBody = response.body() != null ? response.body().bytes() : new byte[0];
            return new HttpResponse(responseBody, response.code());
        }
    }
    
    /**
     * Calculate MD5 hash
     */
    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }
    
    /**
     * Create HTTP client with default configuration
     */
    private static OkHttpClient createHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        
        return new OkHttpClient.Builder()
                .connectTimeout(Constants.DEFAULT_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(Constants.DEFAULT_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(Constants.DEFAULT_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }
    
    /**
     * HTTP response wrapper
     */
    public static class HttpResponse {
        private final byte[] body;
        private final int statusCode;
        
        public HttpResponse(byte[] body, int statusCode) {
            this.body = body;
            this.statusCode = statusCode;
        }
        
        public byte[] getBody() {
            return body;
        }
        
        public int getStatusCode() {
            return statusCode;
        }
    }
} 