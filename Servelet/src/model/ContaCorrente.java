package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numeroConta, Usuario titular) {
        super(numeroConta, titular);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
        }
    }
}
