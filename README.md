# Ejercicios de Entrevista Técnica — Stream API

### Algoritmos reales resueltos con programación funcional en Java

---

## Índice

1. ¿Para qué sirven estos ejercicios?
2. Estructura del proyecto
3. Ejercicio 1 — Top K Endpoints
4. Ejercicio 2 — Majority Element
5. Ejercicio 3 — Transfer Invite Converter

---

## ¿Para qué sirven estos ejercicios?

Estos ejercicios son problemas reales que aparecen en entrevistas técnicas
de empresas de software. No son ejercicios inventados para el curso —
son problemas que el instructor enfrentó en procesos de selección reales.

El objetivo es resolverlos usando **programación funcional con Stream API**.
La mayoría de candidatos los resuelve con loops imperativos.
Tú los vas a resolver con pipelines limpios y expresivos.

> Intenta resolverlo por tu cuenta antes de ver las pistas.
> El objetivo es que entiendas el razonamiento, no memorizar el código.

---

## Estructura del proyecto

```
src/main/java/
│
├── com.interviews.topk
│   ├── TopKEndpoints.java
│   └── Main1.java
│
├── com.interviews.majority
│   ├── MajorityElement.java
│   └── Main2.java
│
└── com.interviews.converter
    ├── TransferInviteConverter.java
    ├── Main3.java
    └── model/
        ├── HostTransferDto.java
        ├── TransferInviteModel.java
        └── TransferStatus.java
```

---

## Ejercicio 1 — Top K Endpoints

**Dificultad:** Intermedio -  Avanzado
**Origen:** Examen técnico estándar — aparece frecuentemente en entrevistas

### El problema

Tienes los logs de tráfico de un servidor web.
Dado un arreglo de URLs y un número `k`,
retorna las `k` URLs más visitadas ordenadas de mayor a menor frecuencia.

```
Entrada:
  urls = ["/home", "/api", "/home", "/login", "/api", "/home"]
  k    = 2

Salida:
  ["/home", "/api"]

  /home   → 3 visitas
  /api    → 2 visitas
  /login  → 1 visita  ← no entra, k = 2
```

### Clase a implementar

```
com.interviews.topk.TopKEndpoints
└── List<String> getTopKEndpoints(String[] urls, int k)
```

### Pistas

```
Paso 1 — contar cuántas veces aparece cada URL
         → necesitas agrupar y contar
         → resultado esperado: Map<String, Long>

Paso 2 — convertir el mapa en un stream de pares clave-valor

Paso 3 — ordenar por frecuencia de mayor a menor

Paso 4 — quedarte solo con los primeros k

Paso 5 — extraer la URL (la clave del par)

Paso 6 — colectar en lista
```

### Operadores que necesitas

`Arrays.stream` — `groupingBy` — `counting` — `entrySet` —
`sorted` — `reversed` — `limit` — `map` — `collect`

---

## Ejercicio 2 — Majority Element

**Dificultad:** Intermedio - Avanzado
**Origen:** LeetCode problema 169 — clásico de entrevistas en FAANG

### El problema

Dado un arreglo de enteros de tamaño `n`,
retorna el elemento que aparece **más de `n/2` veces**.
Se garantiza que ese elemento siempre existe.

```
Entrada: [3, 2, 3]              → 3
Entrada: [2, 2, 1, 1, 1, 2, 2] → 2
Entrada: [-1, 100, 2, 100, 100, -1, 100] → 100
```

### Clase a implementar

```
com.interviews.majority.MajorityElement
└── int majorityElement(int[] nums)
```

### Pistas

```
Paso 1 — construir un mapa de frecuencias
         clave   → el número
         valor   → cuántas veces aparece

         Pista extra: map.merge hace el conteo de una sola línea
         map.merge(numero, 1, Integer::sum)
         → si no existe: inserta con valor 1
         → si ya existe: suma 1 al valor actual

Paso 2 — encontrar la entrada con el valor más alto
         → el número con más apariciones es el mayoritario
```

### Operadores que necesitas

`map.merge` — `BinaryOperator` — `entrySet` — `stream` — `max` — `getKey`

---

## Ejercicio 3 — Transfer Invite Converter

**Dificultad:** Media / Alta
**Origen:** Examen técnico real — proyecto Live Nation

### El problema

El sistema recibe transfers de boletos de un backend externo
y los convierte al modelo interno de la aplicación aplicando
filtros, transformaciones y ordenamiento.

### Clases a implementar

```
com.interviews.converter
├── TransferInviteConverter
│   └── List<TransferInviteModel> convert(List<HostTransferDto> hostTransfers)
│
└── model
    ├── HostTransferDto       — record — datos crudos del backend
    ├── TransferInviteModel   — record — modelo interno de la app
    └── TransferStatus        — enum   — PENDING, ACCEPTED, CANCELLED,
                                         EXPIRED, COMPLETED, UNKNOWN
```

### Reglas de negocio

```
1. Lista nula o vacía → retornar lista vacía de inmediato

2. Excluir transfers sin ID válido
   → transferId nulo o en blanco

3. Excluir transfers cancelados o expirados
   → status CANCELLED o EXPIRED

4. Convertir cada transfer válido:
   id             → transferId
   status         → parsear String al enum TransferStatus
   senderEmail    → copia directa
   recipientEmail → copia directa
   eventId        → copia directa
   eventDate      → parsear a LocalDate, null si no es válido
   ticketCount    → tamaño de ticketIds, 0 si es null

5. Ordenar por eventDate ascendente
   → los transfers sin fecha van al final
```

### Salida esperada con los datos de prueba

```
T002 | ACCEPTED  | 2025-07-15 | tickets: 1
T009 | UNKNOWN   | 2025-08-25 | tickets: 1
T001 | PENDING   | 2025-09-20 | tickets: 3
T008 | PENDING   | 2025-11-30 | tickets: 0
T007 | COMPLETED | null       | tickets: 2
```

### Pistas

```
Paso 1 — validar la lista antes de procesarla

Paso 2 — filtrar transfers sin ID válido
         String.isBlank() es tu mejor amigo aquí

Paso 3 — filtrar por status
         TransferStatus.fromString() ya está implementado

Paso 4 — mapear al modelo interno
         para eventDate necesitas un método helper privado
         que intente el parse y retorne null si falla

Paso 5 — ordenar con null al final
         Comparator.nullsLast(Comparator.naturalOrder())
```

### Operadores que necesitas

`filter` — `map` — `sorted` — `Comparator.nullsLast` —
`Comparator.naturalOrder` — `toList`