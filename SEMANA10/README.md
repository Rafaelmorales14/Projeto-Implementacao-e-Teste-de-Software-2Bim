# Semana 10: prática de TDD

Atividades de Implementação e Teste de Software com Java e JUnit 5. A pasta reúne os quatro exercícios da SEMANA10, cada um com seu projeto Maven.

| Projeto | O que foi implementado |
|: |: |
| [bubblesort-tdd](bubblesort-tdd) | Ordenação crescente de inteiros com Bubble Sort |
| [carrinho-compras-tdd](carrinho-compras-tdd) | Adição, remoção, total da compra e desconto de 10% a partir de R$ 500,00 |
| [conta-bancaria-tdd-maven](conta-bancaria-tdd-maven) | Depósitos, saques e controle do saldo |
| [estoque-tdd](estoque-tdd) | Entrada e retirada de unidades do estoque |

## Como executar

É necessário ter JDK 17 ou superior e Maven instalados. A partir da raiz do repositório:

```bash
cd SEMANA10
mvn test
```

O `pom.xml` desta pasta agrupa os projetos. Para executar um exercício isolado, entre na pasta dele e use o mesmo comando.

## Testes e implementação

Os testes fornecidos de Bubble Sort, conta bancária e estoque foram executados antes da implementação. Depois foram acrescentados testes de limites e preenchidos os métodos que estavam vazios. Os casos de teste originais foram preservados, com ajustes apenas de espaçamento.

No carrinho, os testes foram escritos seguindo a ordem dos seis requisitos: total inicial, um produto, vários produtos, remoção, preço negativo e desconto. Cada etapa foi executada antes e depois da implementação. As primeiras etapas falharam na compilação por falta dos métodos; as seguintes falharam nas verificações do comportamento.

As decisões sobre operações inválidas estão nos READMEs de cada exercício. Os arquivos de requisitos da aula foram incluídos junto aos projetos.

## Resultado

A execução de `mvn clean test` com JDK 21, compilando para Java 17, terminou com `BUILD SUCCESS`.

| Projeto | Testes | Falhas | Erros |
| --- | ---: | ---: | ---: |
| Bubble Sort | 6 | 0 | 0 |
| Carrinho de compras | 13 | 0 | 0 |
| Conta bancária | 8 | 0 | 0 |
| Estoque | 10 | 0 | 0 |
| Total | 37 | 0 | 0 |
