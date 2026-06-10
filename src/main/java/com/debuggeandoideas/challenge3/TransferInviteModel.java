package com.debuggeandoideas.challenge3;

import java.time.LocalDate;
import java.util.Objects;

public class TransferInviteModel {

    private String id;
    private TransferStatus status;
    private String senderEmail;
    private String recipientEmail;
    private String eventId;
    private LocalDate eventDate;
    private int ticketCount;

    public TransferInviteModel(String id, TransferStatus status, String senderEmail,
                               String recipientEmail, String eventId,
                               LocalDate eventDate, int ticketCount) {
        this.id              = id;
        this.status          = status;
        this.senderEmail     = senderEmail;
        this.recipientEmail  = recipientEmail;
        this.eventId         = eventId;
        this.eventDate       = eventDate;
        this.ticketCount     = ticketCount;
    }

    public String getId()                  { return id; }
    public TransferStatus getStatus()      { return status; }
    public String getSenderEmail()         { return senderEmail; }
    public String getRecipientEmail()      { return recipientEmail; }
    public String getEventId()             { return eventId; }
    public LocalDate getEventDate()        { return eventDate; }
    public int getTicketCount()            { return ticketCount; }

    public void setId(String id)                         { this.id = id; }
    public void setStatus(TransferStatus status)         { this.status = status; }
    public void setSenderEmail(String senderEmail)       { this.senderEmail = senderEmail; }
    public void setRecipientEmail(String recipientEmail) { this.recipientEmail = recipientEmail; }
    public void setEventId(String eventId)               { this.eventId = eventId; }
    public void setEventDate(LocalDate eventDate)        { this.eventDate = eventDate; }
    public void setTicketCount(int ticketCount)          { this.ticketCount = ticketCount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferInviteModel m)) return false;
        return Objects.equals(id, m.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TransferInviteModel{id='" + id + "', status=" + status +
                ", eventDate=" + eventDate + ", ticketCount=" + ticketCount + "}";
    }
}