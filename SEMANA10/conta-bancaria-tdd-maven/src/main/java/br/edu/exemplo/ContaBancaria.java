package br.edu.exemplo;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (Double.isFinite(valor) && valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (Double.isFinite(valor) && valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }
}
