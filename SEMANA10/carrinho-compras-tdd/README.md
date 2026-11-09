# Carrinho de compras com TDD

O carrinho guarda uma lista de produtos e calcula o total a partir dos preços. É possível adicionar e remover produtos. Quando a soma chega a R$ 500,00, o total recebe 10% de desconto.

Para o requisito de preço negativo, a escolha foi lançar `IllegalArgumentException` no construtor de `Produto`. Preço zero é aceito. A remoção usa a mesma instância adicionada e retira uma ocorrência por chamada.

Os testes cobrem os seis requisitos de [REQUISITOS.md](REQUISITOS.md), incluindo os valores 499,99, 500,00 e 500,01. Também verificam produtos repetidos, remoção de um produto ausente e o recálculo do desconto após remover um item.

Com JDK 17 ou superior e Maven instalados, execute nesta pasta:

```bash
mvn test
```

Foi mantido o tipo `double` do exercício. Os testes usam tolerância de 0,001 nas comparações e o cálculo não arredonda o resultado para centavos.
