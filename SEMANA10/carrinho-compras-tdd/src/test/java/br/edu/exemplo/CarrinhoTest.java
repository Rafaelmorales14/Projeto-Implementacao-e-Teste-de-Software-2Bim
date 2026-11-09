package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {

    @Test
    void deveIniciarComTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100));

        assertEquals(100, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveSomarVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100));
        carrinho.adicionar(new Produto("Mouse", 50));

        assertEquals(150, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto mouse = new Produto("Mouse", 50);

        carrinho.adicionar(new Produto("Teclado", 100));
        carrinho.adicionar(mouse);
        carrinho.remover(mouse);

        assertEquals(100, carrinho.getTotal(), 0.001);
    }

    @Test
    void naoDevePermitirPrecoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Teclado", -100)
        );
    }

    @Test
    void deveAplicarDezPorCentoDeDesconto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 400));
        carrinho.adicionar(new Produto("Teclado", 200));

        assertEquals(540, carrinho.getTotal(), 0.001);
    }

    @Test
    void naoDeveDarDescontoAbaixoDeQuinhentos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 499.99));

        assertEquals(499.99, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveDarDescontoEmQuinhentosExatos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 500));

        assertEquals(450, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveDarDescontoLogoAcimaDeQuinhentos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 500.01));

        assertEquals(450.009, carrinho.getTotal(), 0.001);
    }
}
