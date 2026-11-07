# Testes de integração com Spring Boot

Exercícios de integração da API de produtos usando Java 17, Maven, Spring Boot, Spring Data JPA, H2, JUnit 5 e MockMvc.

## Como executar

Na raiz do projeto, com JDK 17 ou superior e Maven instalados, execute:

```bash
mvn test
```

## Cenários cobertos

### Service, Repository e H2

- **CT01 — Cadastro válido.** Cadastra `Teclado` por `150.0`, confirma que recebeu um ID e recupera o registro pelo repositório para verificar nome e preço.
- **CT02 — Nome em branco.** Tenta cadastrar um produto de preço `80.0` com nome em branco, verifica a `IllegalArgumentException` e compara a contagem de registros antes e depois.
- **CT03 — Atualização (desafio).** Cadastra `Mouse` por `80.0`, atualiza o preço para `95.0` e consulta o repositório para conferir o valor persistido.

### API com MockMvc

- **CT04 — Cadastro.** Envia `POST /produtos` para cadastrar `Mouse` por `80.0` e verifica HTTP 200, ID numérico, nome e preço no JSON.
- **CT05 — Consulta.** Cadastra o produto via POST, extrai o ID do JSON com Jackson e verifica HTTP 200, ID, nome e preço em `GET /produtos/{id}`.

## Persistência e isolamento

Nos casos de cadastro e atualização pelo service, os testes executam `flush()` para enviar as alterações ao H2 e `clear()` para limpar o contexto de persistência. Assim, `findById()` consulta o banco e permite conferir os valores gravados.

O Spring abre uma transação para cada método de teste anotado com `@Transactional`, inclusive quando a anotação está na classe, e faz rollback ao final por padrão. Cada teste prepara seus próprios dados.

O MockMvc encaminha as requisições simuladas ao `DispatcherServlet` sem abrir uma porta HTTP. As chamadas passam pelo controller, pelo service e pelo repositório real até o H2. Um teste unitário do controller com um service simulado verificaria o comportamento isolado do controller.

## Resultado da execução

A suíte Maven foi executada com JDK 21 e compilação para Java 17. O Maven Surefire registrou o seguinte resultado:

```text
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
