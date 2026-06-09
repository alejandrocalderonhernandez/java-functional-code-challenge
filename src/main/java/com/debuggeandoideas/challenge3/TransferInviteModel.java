package com.debuggeandoideas.challenge3;

public record TransferInviteModel(
        String id,
        TransferStatus status,
        String senderEmail,
        String recipientEmail,
        String eventId,
        LocalDate eventDate,
        int ticketCount
) {}