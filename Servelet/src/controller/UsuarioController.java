package controller;

import model.Banco;
import model.Usuario;

public class UsuarioController {
    private Banco banco;

    public UsuarioController(Banco banco) {
        this.banco = banco;
    }

    public boolean cadastrarUsuario(String nome, String cpf, String senha) {
        // Verifica se o usuário já existe
        for (Usuario usuarioExistente : banco.getUsuarios()) {
            if (usuarioExistente.getCpf().equals(cpf)) {
                return false; // Usuário já existe
            }
        }
        Usuario novoUsuario = new Usuario(nome, cpf, senha);
        banco.adicionarUsuario(novoUsuario);
        return true;
    }

    public Usuario autenticarUsuario(String cpf, String senha) {
        return banco.buscarUsuario(cpf, senha);
    }
}
