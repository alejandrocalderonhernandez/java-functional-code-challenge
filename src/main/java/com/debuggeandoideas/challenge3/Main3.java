package com.debuggeandoideas.challenge3;

import java.util.List;

public class Main3 {

    public static void main(String[] args) {

        List<HostTransferDto> transfers = List.of(

                // caso normal — debe aparecer
                new HostTransferDto("T001", "PENDING",
                        "sender1@mail.com", "recipient1@mail.com",
                        "EVT-001", "2025-09-20",
                        List.of("TK-1", "TK-2", "TK-3")),

                // caso normal — debe aparecer, fecha anterior → va primero
                new HostTransferDto("T002", "ACCEPTED",
                        "sender2@mail.com", "recipient2@mail.com",
                        "EVT-002", "2025-07-15",
                        List.of("TK-4")),

                // CANCELLED — debe excluirse
                new HostTransferDto("T003", "CANCELLED",
                        "sender3@mail.com", "recipient3@mail.com",
                        "EVT-003", "2025-08-10",
                        List.of("TK-5")),

                // EXPIRED — debe excluirse
                new HostTransferDto("T004", "EXPIRED",
                        "sender4@mail.com", "recipient4@mail.com",
                        "EVT-004", "2025-06-01",
                        List.of("TK-6")),

                // transferId nulo — debe excluirse
                new HostTransferDto(null, "PENDING",
                        "sender5@mail.com", "recipient5@mail.com",
                        "EVT-005", "2025-10-01",
                        List.of("TK-7")),

                // transferId en blanco — debe excluirse
                new HostTransferDto("   ", "PENDING",
                        "sender6@mail.com", "recipient6@mail.com",
                        "EVT-006", "2025-10-05",
                        List.of("TK-8")),

                // fecha nula — debe aparecer al final
                new HostTransferDto("T007", "COMPLETED",
                        "sender7@mail.com", "recipient7@mail.com",
                        "EVT-007", null,
                        List.of("TK-9", "TK-10")),

                // ticketIds nulo — ticketCount debe ser 0
                new HostTransferDto("T008", "PENDING",
                        "sender8@mail.com", "recipient8@mail.com",
                        "EVT-008", "2025-11-30",
                        null),

                // status desconocido — debe aparecer como UNKNOWN
                new HostTransferDto("T009", "WHATEVER",
                        "sender9@mail.com", "recipient9@mail.com",
                        "EVT-009", "2025-08-25",
                        List.of("TK-11"))
        );

        TransferInviteConverter converter = new TransferInviteConverter();
        List<TransferInviteModel> result = converter.convert(transfers);

        IO.println("Total resultados: " + result.size()); // esperado: 6

        result.forEach(t ->
                IO.println(t.id() + " | " + t.status() + " | " +
                        t.eventDate() + " | tickets: " + t.ticketCount())
        );

        // salida esperada (ordenada por fecha ascendente, null al final):
        // T002 | ACCEPTED   | 2025-07-15 | tickets: 1
        // T009 | UNKNOWN    | 2025-08-25 | tickets: 1
        // T001 | PENDING    | 2025-09-20 | tickets: 3
        // T008 | PENDING    | 2025-11-30 | tickets: 0
        // T007 | COMPLETED  | null       | tickets: 2
    }
}
