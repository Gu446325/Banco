package model;

public abstract class Conta {
    protected String numeroConta;
    protected double saldo;
    protected Usuario titular;

    public Conta(String numeroConta, Usuario titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
    }

    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract void transferir(double valor, Conta contaDestino);

    // Getters e Setters
    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getTitular() {
        return titular;
    }
}
