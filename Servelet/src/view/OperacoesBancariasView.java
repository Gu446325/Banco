package view;

import controller.ContaController;
import model.Conta;

import javax.swing.*;

public class OperacoesBancariasView {

    private ContaController contaController;
    private Conta conta;

    public OperacoesBancariasView(ContaController contaController, Conta conta) {
        this.contaController = contaController;
        this.conta = conta;
    }

    public void exibirMenu() {
        int escolha = 0; // Inicializado para entrar no loop
        while (escolha != -1 && escolha != 5) { // Adiciona condição de "Voltar ao Login"
            String[] options = {"Depositar", "Sacar", "Transferir", "Consultar Saldo", "Sair", "Voltar ao Login"};
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma operação", "Operações Bancárias",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            switch (escolha) {
                case 0: // Depositar
                    realizarDeposito();
                    break;
                case 1: // Sacar
                    realizarSaque();
                    break;
                case 2: // Transferir
                    realizarTransferenciaPorCPF(); // Método modificado para transferir por CPF
                    break;
                case 3: // Consultar Saldo
                    consultarSaldo();
                    break;
                case 4: // Sair
                    System.exit(0); // Encerra a aplicação
                    break;
                case 5: // Voltar ao Login
                    return; // Simplesmente retorna, o loop no main tratará o relogin
                default:
                    escolha = -1;
                    break;
            }
        }
    }


    private void realizarDeposito() {
        String valor = JOptionPane.showInputDialog(null, "Valor para Depósito:", "Depósito", JOptionPane.QUESTION_MESSAGE);
        contaController.realizarDeposito(conta, Double.parseDouble(valor));
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarSaque() {
        String valor = JOptionPane.showInputDialog(null, "Valor para Saque:", "Saque", JOptionPane.QUESTION_MESSAGE);
        if (contaController.realizarSaque(conta, Double.parseDouble(valor))) {
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarSaldo() {
        double saldo = contaController.consultarSaldo(conta);
        JOptionPane.showMessageDialog(null, "Saldo atual: " + saldo, "Saldo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void realizarTransferenciaPorCPF() {
        String cpfDestino = JOptionPane.showInputDialog(null, "CPF do Destinatário:", "Transferência", JOptionPane.QUESTION_MESSAGE);
        String valor = JOptionPane.showInputDialog(null, "Valor para Transferência:", "Transferência", JOptionPane.QUESTION_MESSAGE);
        
        if (cpfDestino != null && !cpfDestino.trim().isEmpty() && contaController.realizarTransferencia(conta, cpfDestino, Double.parseDouble(valor))) {
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao realizar transferência. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


}
