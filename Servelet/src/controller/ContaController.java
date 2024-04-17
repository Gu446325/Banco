package controller;

import java.util.UUID;

import model.Banco;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Usuario;

public class ContaController {
    private Banco banco;

    public ContaController(Banco banco) {
        this.banco = banco;
    }

    public Conta criarConta(String tipo, Usuario titular) {
        String numeroConta = UUID.randomUUID().toString(); // Gera um número de conta
        Conta novaConta;

        switch (tipo.toLowerCase()) {
            case "corrente":
                novaConta = new ContaCorrente(numeroConta, titular);
                break;
            case "poupanca":
                novaConta = new ContaPoupanca(numeroConta, titular);
                break;
            default:
                return null; // Tipo de conta inválido
        }

        banco.adicionarConta(novaConta);
        return novaConta;
    }

    public boolean realizarSaque(Conta conta, double valor) {
        return conta.sacar(valor);
    }

    public void realizarDeposito(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public boolean realizarTransferencia(Conta contaOrigem, String cpfDestinatario, double valor) {
        Conta contaDestino = encontrarContaPorCPF(cpfDestinatario);
        if (contaDestino != null && contaOrigem.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public Conta encontrarContaPorCPF(String email) {
        for (Conta conta : banco.getContas()) {
            if (conta.getTitular().getEmail().equals(email)) {
                // Aqui, você pode decidir qual conta escolher se o usuário tiver múltiplas
                return conta;
            }
        }
        return null; // Não encontrou a conta com o CPF fornecido
    }


    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

}
