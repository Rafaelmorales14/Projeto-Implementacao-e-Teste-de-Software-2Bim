package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoLimitesTest {

    @Test
    void deveGuardarNomeDoProduto() {

        assertEquals("Teclado", new Produto("Teclado").getNome());
    }

    @Test
    void naoDeveAlterarEstoqueComEntradaZeroOuNegativa() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.adicionarEstoque(0);
        produto.adicionarEstoque(-5);

        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void naoDeveAlterarEstoqueComRetiradaZeroOuNegativa() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(0);
        produto.retirarEstoque(-5);

        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void devePermitirRetirarTodoOEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(10);

        assertEquals(0, produto.getQuantidade());
    }
}
