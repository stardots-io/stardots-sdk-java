package io.stardots.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.stardots.sdk.model.CommonResponse;

/**
 * Get file access ticket response data structure
 */
public class FileAccessTicketResp extends CommonResponse {
    
    /**
     * Ticket data wrapper
     */
    public static class TicketData {
        @JsonProperty("ticket")
        private String ticket;
        
        public TicketData() {}
        
        public TicketData(String ticket) {
            this.ticket = ticket;
        }
        
        public String getTicket() {
            return ticket;
        }
        
        public void setTicket(String ticket) {
            this.ticket = ticket;
        }
        
        @Override
        public String toString() {
            return "TicketData{" +
                    "ticket='" + ticket + '\'' +
                    '}';
        }
    }
    
    /**
     * Ticket data
     */
    @JsonProperty("data")
    private TicketData data;
    
    // Constructors
    public FileAccessTicketResp() {
        super();
    }
    
    public FileAccessTicketResp(TicketData data) {
        this.data = data;
    }
    
    // Getters and Setters
    public TicketData getData() {
        return data;
    }
    
    public void setData(TicketData data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "FileAccessTicketResp{" +
                "data=" + data +
                "} " + super.toString();
    }
} 