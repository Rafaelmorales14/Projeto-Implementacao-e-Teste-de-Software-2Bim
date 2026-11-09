package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaLimitesTest {

    @Test
    void deveIniciarComSaldoZero() {

        assertEquals(0, new ContaBancaria().getSaldo(), 0.001);
    }

    @Test
    void devePermitirSaqueDoSaldoInteiro() {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(100);
        conta.sacar(100);

        assertEquals(0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAlterarSaldoComDepositoInvalido() {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(100);
        conta.depositar(-50);
        conta.depositar(0);
        conta.depositar(Double.NaN);
        conta.depositar(Double.POSITIVE_INFINITY);

        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAlterarSaldoComSaqueInvalido() {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(100);
        conta.sacar(-50);
        conta.sacar(0);
        conta.sacar(Double.NaN);
        conta.sacar(Double.POSITIVE_INFINITY);

        assertEquals(100, conta.getSaldo(), 0.001);
    }
}
