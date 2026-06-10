package com.debuggeandoideas.challenge3;

import java.util.List;
import java.util.Objects;

public class HostTransferDto {

    private String transferId;
    private String status;
    private String senderEmail;
    private String recipientEmail;
    private String eventId;
    private String eventDate;
    private List<String> ticketIds;

    public HostTransferDto(String transferId, String status, String senderEmail,
                           String recipientEmail, String eventId,
                           String eventDate, List<String> ticketIds) {
        this.transferId      = transferId;
        this.status          = status;
        this.senderEmail     = senderEmail;
        this.recipientEmail  = recipientEmail;
        this.eventId         = eventId;
        this.eventDate       = eventDate;
        this.ticketIds       = ticketIds;
    }

    public String getTransferId()          { return transferId; }
    public String getStatus()              { return status; }
    public String getSenderEmail()         { return senderEmail; }
    public String getRecipientEmail()      { return recipientEmail; }
    public String getEventId()             { return eventId; }
    public String getEventDate()           { return eventDate; }
    public List<String> getTicketIds()     { return ticketIds; }

    public void setTransferId(String transferId)         { this.transferId = transferId; }
    public void setStatus(String status)                 { this.status = status; }
    public void setSenderEmail(String senderEmail)       { this.senderEmail = senderEmail; }
    public void setRecipientEmail(String recipientEmail) { this.recipientEmail = recipientEmail; }
    public void setEventId(String eventId)               { this.eventId = eventId; }
    public void setEventDate(String eventDate)           { this.eventDate = eventDate; }
    public void setTicketIds(List<String> ticketIds)     { this.ticketIds = ticketIds; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HostTransferDto d)) return false;
        return Objects.equals(transferId, d.transferId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transferId);
    }

    @Override
    public String toString() {
        return "HostTransferDto{transferId='" + transferId + "', status='" + status + "'}";
    }
}