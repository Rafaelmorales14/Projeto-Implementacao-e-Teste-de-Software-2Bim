# Conta bancária com TDD

A conta começa com saldo zero. Os depósitos se acumulam e os saques são realizados quando há saldo suficiente. Uma tentativa de saque acima do saldo é ignorada, conforme o teste fornecido.

Também são ignorados valores negativos, zero e valores não finitos, como `NaN` e infinito. Os quatro testes originais foram preservados, com testes adicionais para saldo inicial, saque de todo o saldo e operações inválidas.

Com JDK 17 ou superior e Maven instalados, execute nesta pasta:

```bash
mvn test
```

Os valores usam `double`, seguindo a estrutura da atividade.
