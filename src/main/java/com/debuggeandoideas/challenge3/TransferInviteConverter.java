package com.debuggeandoideas.challenge3;

import java.time.LocalDate;
import java.util.List;

public class TransferInviteConverter {


    /**
     * Convierte una lista de transfers DTO del backend en modelos listos para mostrar.
     * Reglas de negocio (en orden):
     * 1. Si la lista es nula o está vacía — retornar una lista vacía de inmediato.
     * 2. Ignorar cualquier transfer que no tenga un ID válido (nulo o en blanco).
     * 3. Ignorar cualquier transfer que esté CANCELADO o EXPIRADO.
     * 4. Convertir cada transfer válido al modelo de la aplicación:
     * - id → copiar el transferId
     * - status → convertir el String al enum TransferStatus
     * - senderEmail   → copiar directo
     * - recipientEmail → copiar directo
     * - eventId       → copiar directo
     * - eventDate     → convertir el String a LocalDate, null si no es válido
     * - ticketCount   → contar los tickets, 0 si la lista es nula
     *
     * 5. Ordenar por fecha de evento de más próxima a más lejana.
     * Los transfers sin fecha van al final.
     *
     * @param hostTransfers lista de transfers del backend, puede ser null
     * @return lista procesada, nunca null
     */
    public List<TransferInviteModel> convert(List<HostTransferDto> hostTransfers) {

        // PISTA 1 — antes de hacer cualquier cosa, valida la lista
        // ¿qué pasa si hostTransfers es null o está vacía?
        // List.of() te da una lista vacía inmutable



        // PISTA 2 — abre un stream sobre la lista
        // hostTransfers.stream()



        // PISTA 3 — primer filtro: transferId no debe ser nulo ni en blanco
        // .filter(...)
        // String tiene un método que verifica si está en blanco — ¿cuál es?



        // PISTA 4 — segundo filtro: excluir CANCELLED y EXPIRED
        // .filter(...)
        // TransferStatus.fromString() ya está implementado — úsalo aquí
        // necesitas comparar el status resultante contra dos valores del enum



        // PISTA 5 — convertir HostTransferDto → TransferInviteModel
        // .map(dto -> new TransferInviteModel(...))
        // para eventDate necesitas un método privado que haga el parse
        // LocalDate.parse() lanza excepción si el formato es inválido — manéjala
        // para ticketCount — ¿qué pasa si ticketIds es null?



        // PISTA 6 — ordenar por eventDate ascendente, null al final
        // .sorted(Comparator.comparing(...))
        // hay un método en Comparator que empuja los null al final — búscalo
        // Comparator.nulls???



        // PISTA 7 — colectar el resultado
        // .toList()

        throw new UnsupportedOperationException("No implementado aún");
    }


    // PISTA — método helper para parsear la fecha(Ya esta funcionando)
    private LocalDate parseDate(String eventDate) {
        if (eventDate == null || eventDate.isBlank()) {
            return null;
        }
        try {
            return LocalDate.parse(eventDate);
        } catch (
                Exception e) {
            return null;
        }
    }
}
