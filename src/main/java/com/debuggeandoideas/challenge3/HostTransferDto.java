package com.debuggeandoideas.challenge3;

import java.util.List;

public record HostTransferDto(
        String transferId,
        String status,
        String senderEmail,
        String recipientEmail,
        String eventId,
        String eventDate,
        List<String> ticketIds
) {}