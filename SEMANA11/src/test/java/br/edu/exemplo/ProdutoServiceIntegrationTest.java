package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {
    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void deveCadastrarERecuperarProduto() {
        Produto cadastrado = service.cadastrar("Teclado", 150.0);
        assertNotNull(cadastrado.getId());

        entityManager.flush();
        entityManager.clear();

        Produto recuperado = repository.findById(cadastrado.getId()).orElseThrow();
        assertEquals("Teclado", recuperado.getNome());
        assertEquals(150.0, recuperado.getPreco());
    }

    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        long quantidadeAntes = repository.count();

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar(" ", 80.0));

        assertEquals(quantidadeAntes, repository.count());
    }

    @Test
    void deveAtualizarPrecoPersistido() {
        Produto cadastrado = service.cadastrar("Mouse", 80.0);

        service.atualizarPreco(cadastrado.getId(), 95.0);
        entityManager.flush();
        entityManager.clear();

        Produto atualizado = repository.findById(cadastrado.getId()).orElseThrow();
        assertEquals(95.0, atualizado.getPreco());
    }
}
