---
name: review-transfer-tests
description: Use para conferir se os testes do TransferService cobrem todas as regras descritas em docs/spec.md. Só lista o que falta, não escreve testes.
---

# Revisar cobertura de testes do transferMoney

## Arquivos
- Spec: `docs/spec.md`
- Código: `src/main/java/com/Rychlewski/DesafioItauFinancia/service/TransferService.java`
- Testes: `src/test/java/com/Rychlewski/DesafioItauFinancia/service/TransferServiceTest.java`

## Passos
1. Leia `docs/spec.md` e liste todas as regras de validação e garantias (concorrência e idempotência).
2. Leia `TransferServiceTest` e anote o que cada teste verifica.
3. Para cada regra da spec, diga se existe um teste que a cobre. Se existir, cite o nome do método.
4. Liste as regras sem teste, ordenadas da mais importante para a menos importante.

## Para rodar os testes (se for necessário)
- Comando no Windows: `.\mvnw.cmd test`
- Testes unitários rodam sozinhos. O teste de concorrência e o `contextLoads` precisam de Docker aberto e das variáveis do `.env` carregadas no terminal.
- Nunca leia nem exiba o conteúdo do arquivo `.env`.

## Regras
- NÃO escreva nem altere testes ou código. Apenas liste o que falta.
- Para cada regra sem teste, diga em uma frase **qual cenário** precisaria ser testado e **o que o teste deveria conferir**.
- Quem escreve o teste é o desenvolvedor, não o agente.

## Formato da resposta
Uma tabela com as colunas: Regra | Coberta? | Teste (ou "falta") | Cenário sugerido.