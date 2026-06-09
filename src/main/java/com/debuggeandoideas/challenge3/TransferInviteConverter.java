package com.debuggeandoideas.challenge3;

import java.util.List;

public class TransferInviteConverter {

    /**
     * Convierte una lista de transfers crudos del backend en modelos listos para mostrar.
     * Reglas de negocio (en orden):
     * 1. Si la lista es nula o está vacía — retornar una lista vacía de inmediato.
     * 2. Ignorar cualquier transfer que no tenga un ID válido (nulo o en blanco).
     * 3. Ignorar cualquier transfer que esté CANCELADO o EXPIRADO.
     * 4. Convertir cada transfer válido al modelo de la aplicación:
     *    - id → copiar el transferId
     *    - status → convertir el String al enum TransferStatus
     *    - senderEmail   → copiar directo
     *    - recipientEmail → copiar directo
     *    - eventId       → copiar directo
     *    - eventDate     → convertir el String a LocalDate, null si no es válido
     *    - ticketCount   → contar los tickets, 0 si la lista es nula
     *
     * 5. Ordenar por fecha de evento de más próxima a más lejana.
     *    Los transfers sin fecha van al final.
     *
     * @param hostTransfers lista de transfers del backend, puede ser null
     * @return lista procesada, nunca null
     */
    public List<TransferInviteModel> convert(List<HostTransferDto> hostTransfers) {
        // TODO: implementar este método
        throw new UnsupportedOperationException("No implementado aún");
    }

    // -------------------------------------------------------------------------
    // Puedes agregar métodos privados de ayuda debajo de esta línea
    // -------------------------------------------------------------------------
}
