package com.debuggeandoideas.challenge3;

import java.util.Arrays;

public enum TransferStatus {
    PENDING,
    ACCEPTED,
    CANCELLED,
    EXPIRED,
    COMPLETED,
    UNKNOWN;

    public static TransferStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return UNKNOWN;
        }
        return Arrays.stream(values())
                .filter(s -> s.name().equalsIgnoreCase(value.trim()))
                .findFirst()
                .orElse(UNKNOWN);
    }
}