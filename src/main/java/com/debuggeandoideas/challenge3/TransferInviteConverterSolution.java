package com.debuggeandoideas.challenge3;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class TransferInviteConverterSolution {

    public List<TransferInviteModel> convert(List<HostTransferDto> hostTransfers) {

        // regla 1 — lista nula o vacía retorna inmediatamente
        // no tiene sentido procesar nada si no hay datos
        if (hostTransfers == null || hostTransfers.isEmpty()) {
            return List.of();
        }

        return hostTransfers.stream()

                // regla 2 — excluir transfers sin ID válido
                // un transfer sin ID no se puede identificar en el sistema
                .filter(dto -> dto.getTransferId() != null
                        && !dto.getTransferId().isBlank())

                // regla 3 — excluir CANCELLED y EXPIRED
                // estos transfers ya no son accionables para el usuario
                .filter(dto -> {
                    TransferStatus status = TransferStatus.fromString(dto.getStatus());
                    return status != TransferStatus.CANCELLED
                            && status != TransferStatus.EXPIRED;
                })

                // regla 4 — convertir al modelo interno de la aplicación
                // transformamos el contrato del backend al contrato interno
                .map(dto -> new TransferInviteModel(
                        dto.getTransferId(),
                        TransferStatus.fromString(dto.getStatus()),
                        dto.getSenderEmail(),
                        dto.getRecipientEmail(),
                        dto.getEventId(),
                        parseDate(dto.getEventDate()),            // puede retornar null
                        dto.getTicketIds() != null                // null → 0
                                ? dto.getTicketIds().size() : 0
                ))

                // regla 5 — ordenar por fecha ascendente, null al final
                // nullsLast garantiza que los transfers sin fecha van al final
                // sin nullsLast el stream lanzaría NullPointerException en runtime
                .sorted(Comparator.comparing(
                        TransferInviteModel::getEventDate,
                        Comparator.nullsLast(Comparator.naturalOrder())
                ))

                .toList();
    }

    // intenta parsear el String como LocalDate
    // retorna null si el valor es nulo, en blanco o tiene formato inválido
    // LocalDate.parse() entiende el formato ISO-8601 — ejemplo: "2025-09-20"
    private LocalDate parseDate(String eventDate) {
        if (eventDate == null || eventDate.isBlank()) {
            return null;
        }
        try {
            return LocalDate.parse(eventDate);
        } catch (Exception e) {
            return null;
        }
    }
}
