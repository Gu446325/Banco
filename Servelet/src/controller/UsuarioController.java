package controller;

import model.Banco;
import model.Usuario;

public class UsuarioController {
    private Banco banco;

    public UsuarioController(Banco banco) {
        this.banco = banco;
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        // Verifica se o usuário já existe
        for (Usuario usuarioExistente : banco.getUsuarios()) {
            if (usuarioExistente.getEmail().equals(email)) {
                return false; // Usuário já existe
            }
        }
        Usuario novoUsuario = new Usuario(nome, email, senha);
        banco.adicionarUsuario(novoUsuario);
        return true;
    }

    public Usuario autenticarUsuario(String email, String senha) {
        return banco.buscarUsuario(email, senha);
    }
}
