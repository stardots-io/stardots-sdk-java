package io.stardots.sdk;

/**
 * Constants for StarDots SDK
 */
public final class Constants {
    
    /**
     * SDK version
     */
    public static final String SDK_VERSION = "1.0.0";
    
    /**
     * Request the endpoint of the stardots server.
     */
    public static final String ENDPOINT = "https://api.stardots.io";
    
    /**
     * Default request timeout, unit: milliseconds
     */
    public static final long DEFAULT_REQUEST_TIMEOUT = 30000L;
    
    private Constants() {
        // Utility class, prevent instantiation
    }
} 