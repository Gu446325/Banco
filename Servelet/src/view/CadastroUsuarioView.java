package view;

import controller.UsuarioController;

import javax.swing.*;

public class CadastroUsuarioView {

    private UsuarioController usuarioController;

    public CadastroUsuarioView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void exibir() {
        String nome = JOptionPane.showInputDialog(null, "Nome Completo:", "Cadastro de Usuário", JOptionPane.QUESTION_MESSAGE);
        String cpf = JOptionPane.showInputDialog(null, "CPF:", "Cadastro de Usuário", JOptionPane.QUESTION_MESSAGE);
        String senha = JOptionPane.showInputDialog(null, "Crie uma Senha:", "Cadastro de Usuário", JOptionPane.QUESTION_MESSAGE);

        if (usuarioController.cadastrarUsuario(nome, cpf, senha)) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário. CPF já pode estar em uso.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
