# Especificação: transferência entre contas

## Regras de validação

| Regra | Quando é verificada | Exceção | Status HTTP |
|---|---|---|---|
| Valor da transferência deve ser maior que zero | Antes do lock | `InvalidAmountException` | 400 |
| Origem e destino não podem ser a mesma conta | Antes do lock (compara os IDs do request, sem consultar o banco) | `SameAccountTransferException` | 422 |
| As duas contas precisam existir | Depois do lock | `AccountNotFoundException` | 404 |
| As duas contas precisam estar ativas | Depois do lock | `InactiveAccountException` | 422 |
| Saldo da origem deve cobrir o valor (erro só se saldo < valor; igual é permitido) | Depois do lock | `InsufficientBalanceException` | 422 |

## Garantias

### Concorrência
- As duas contas são travadas com lock pessimista, sempre na mesma ordem (menor UUID primeiro), para evitar deadlock.
- O lock é liberado no fim da transação (commit ou rollback).

### Idempotência
- A `Idempotency-Key` e o comprovante são salvos no fim do método, na mesma transação.
- Em caso de erro, o rollback apaga tudo e o cliente pode repetir o pedido.
- Em caso de sucesso, repetir a mesma chave devolve o comprovante original, sem mexer no dinheiro.