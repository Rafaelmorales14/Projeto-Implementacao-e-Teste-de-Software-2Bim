package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarrinhoLimitesTest {

    @Test
    void deveAceitarProdutoGratuito() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Brinde", 0));

        assertEquals(0, carrinho.getTotal(), 0.001);
    }

    @Test
    void removerProdutoAusenteNaoDeveAlterarTotal() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100));

        carrinho.remover(new Produto("Mouse", 50));

        assertEquals(100, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRemoverUmaOcorrenciaDoProdutoRepetido() {
        Carrinho carrinho = new Carrinho();
        Produto mouse = new Produto("Mouse", 50);

        carrinho.adicionar(mouse);
        carrinho.adicionar(mouse);

        carrinho.remover(mouse);

        assertEquals(50, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRetirarDescontoQuandoSubtotalFicarAbaixoDoLimite() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 200);

        carrinho.adicionar(new Produto("Monitor", 400));
        carrinho.adicionar(teclado);

        assertEquals(540, carrinho.getTotal(), 0.001);

        carrinho.remover(teclado);

        assertEquals(400, carrinho.getTotal(), 0.001);
    }
}
