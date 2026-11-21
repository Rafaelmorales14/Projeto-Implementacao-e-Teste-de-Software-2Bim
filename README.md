# Implementação e Teste de Software — 2º bimestre

Trabalho acadêmico da disciplina de **Implementação e Teste de Software**. O repositório reúne as atividades do segundo bimestre sobre desenvolvimento orientado a testes (TDD), testes de integração e avaliação de usabilidade com usuário final.

## Atividades

- **Semana 10 — Prática de TDD.** Exercícios de Bubble Sort, carrinho de compras, conta bancária e estoque em Java. Os testes unitários usam JUnit 5 e incluem casos de limite. [Atividades e instruções da Semana 10](SEMANA10/README.md)
- **Semana 11 — Testes de integração.** Uma API de produtos em Spring Boot, com testes de cadastro, consulta, atualização e validação. A suíte usa H2 para verificar a persistência e MockMvc para verificar as respostas HTTP. [Atividades e instruções da Semana 11](SEMANA11/README.md)
- **Semana 14 — Teste com usuário final.** Roteiro e registro de observação de um teste de usabilidade no Mercado Livre. A atividade acompanha a busca e a comparação de produtos até a simulação de compra, sem concluir o pagamento. [Roteiro e observações da Semana 14](SEMANA14/README.md)

## Como executar os testes automatizados

Com JDK 17 ou superior e Maven instalados, execute os comandos na raiz do repositório.

```sh
mvn -f SEMANA10/pom.xml test
mvn -f SEMANA11/pom.xml test
```

## Contribuintes

- **Lucas Domingues de Souza** — RA `24538741-2`
- **Rafael Blasques Morales** — RA `241248722`
