package api;

import controller.ContaController;
import controller.UsuarioController;
import model.Banco;
import model.Conta;
import model.Usuario;
import view.CadastroUsuarioView;
import view.LoginView;
import view.OperacoesBancariasView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        UsuarioController usuarioController = new UsuarioController(banco);
        ContaController contaController = new ContaController(banco);

        while (true) {
            Object[] options = {"Login", "Cadastrar", "Listar Usuários"};
            int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Banco GPT! Escolha uma opção:", "Banco GPT",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            switch (escolha) {
            case 0: // Login
            	  LoginView loginView = new LoginView(usuarioController);
                  Usuario usuarioLogado = loginView.exibir();
                  if (usuarioLogado != null) {
                      // Simples exemplo de criação de conta e operações bancárias após o login
                      Conta conta = contaController.criarConta("corrente", usuarioLogado);
                      OperacoesBancariasView operacoesBancariasView = new OperacoesBancariasView(contaController, conta);
                      operacoesBancariasView.exibirMenu();
                  }
                break;
            case 1: // Cadastrar
            	 CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView(usuarioController);
                 cadastroUsuarioView.exibir();
                break;
            case 2: // Listar Usuários
                listarUsuarios(banco);
                break;
            default:
                System.exit(0);
        }
        }
    }
    
    private static void listarUsuarios(Banco banco) {
        StringBuilder usuariosStr = new StringBuilder("Usuários Cadastrados:\n");
        for (Usuario usuario : banco.getUsuarios()) {
            usuariosStr.append("Nome: ").append(usuario.getNome()).append(", CPF: ").append(usuario.getCpf()).append("\n");
        }
        JOptionPane.showMessageDialog(null, usuariosStr.toString());
    }
}
