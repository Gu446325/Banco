package api;


import controller.UsuarioController;
import model.Banco;
import model.Conta;
import model.Usuario;
import view.CadastroUsuarioView;



import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        while (true) {
            Object[] options = {"Login", "Cadastrar"};
            int escolha = JOptionPane.showOptionDialog(null, "Seja Bem-vindo ao Gerenciamento de Eventos Web! Escolha uma opção:", "Gerenciamento de Eventos Web",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            switch (escolha) {
            case 0: // Login
            	 {
                  }
                break;
            case 1: // Cadastrar
     
        }}}}
       
    
    
   
       


