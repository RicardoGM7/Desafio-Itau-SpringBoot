# Desafio Itaú - API de Transações

API REST desenvolvida com Spring Boot para registrar transações financeiras e consultar estatísticas consolidadas.

## Tecnologias

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Bean Validation
- Lombok
- Maven

A aplicação será iniciada em `http://localhost:8080`.

## Endpoints

### Criar uma transação

**POST** `/transacao`

Corpo da requisição:

```json
{
  "valor": 100.50,
  "dataHora": "2026-09-08T15:30:00-03:00"
}
```

Retornos:

- `201 Created`: transação registrada
- `422 Unprocessable Entity`: valor negativo ou data futura
- `400 Bad Request`: campos obrigatórios ausentes ou inválidos

### Consultar estatísticas

**GET** `/estatistica`

Exemplo:

```bash
curl http://localhost:8080/estatistica
```

Resposta:

```json
{
  "count": 1,
  "sum": 100.5,
  "avg": 100.5,
  "min": 100.5,
  "max": 100.5
}
```

As estatísticas são calculadas sobre as transações armazenadas em memória durante a execução da aplicação. Quando não existem transações, os valores numéricos retornam como `0`.

### Limpar transações

**DELETE** `/transacao`

Exemplo:

```bash
curl -X DELETE http://localhost:8080/transacao
```

Retorno:

- `200 OK`: todas as transações foram removidas
`

## Estrutura principal

```text
src/main/java/com/Desafio2/itau
├── controller
│   ├── EstatisticsController.java
│   └── TransactionController.java
├── dto
│   ├── StatisticsResponse.java
│   └── TransactionRequest.java
├── entities
│   └── Transaction.java
└── service
    └── TransactionService.java
```

Os dados são mantidos em uma fila concorrente na memória e não são persistidos em banco de dados. Portanto, as transações são perdidas quando a aplicação é encerrada.
