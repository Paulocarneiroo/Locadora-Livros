package entidades;
import repositories.BancoDeDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Livro> livros = new ArrayList<>();

    private static final BancoDeDados bd = new BancoDeDados();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void exibirMenu(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("BEM-VINDO " + nome);
            System.out.println("1. Ver catálogo de livros");
            System.out.println("2. Ver Perfil");
            System.out.println("0. Sair");

            opt = sc.nextInt();
            switch (opt){
                case 1:
                    bd.mostrarLivros();
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
            }
        }while (opt != 0);
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + "Email: " + email;
    }
}
