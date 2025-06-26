package io.stardots.sdk;

import io.stardots.sdk.Constants;

/**
 * StarDots SDK factory class
 */
public class StarDotsFactory {
    
    /**
     * Create a new StarDots SDK instance
     */
    public static StarDots create(String clientKey, String clientSecret) {
        return create(clientKey, clientSecret, Constants.ENDPOINT);
    }
    
    /**
     * Create a new StarDots SDK instance with custom endpoint
     */
    public static StarDots create(String clientKey, String clientSecret, String endpoint) {
        return new StarDotsImpl(clientKey, clientSecret, endpoint);
    }
} 