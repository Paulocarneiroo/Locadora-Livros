import entidades.Livro;
import entidades.Usuario;
import repositories.BancoDeDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*---BANCO DE DADOS---*/
        BancoDeDados bd = new BancoDeDados();
        /*--------------------*/

        int opt = 0;
        do {
            System.out.println("1. Fazer cadastro");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção >> ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    System.out.print("Digite seu nome: ");
                    String name = sc.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = sc.nextLine();
                    System.out.println();
                    Usuario usuario = new Usuario(name, email, senha);
                    bd.getUsuarios().add(usuario);
                    System.out.println("=========================");
                    System.out.println("Cadastro realizado, bem-vindo " + usuario.getNome());
                    System.out.println("=========================");
                    break;
                case 2:
                    if (bd.getUsuarios().isEmpty()){
                        System.out.println("Sistema sem usuários, faça cadastro primeiro");
                        System.out.println();
                        break;
                    }else {
                        System.out.print("Digite seu email:");
                        String emailParaAprovar = sc.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senhaParaAprovar = sc.nextLine();
                        System.out.println();
                        for (Usuario user : bd.getUsuarios()){
                            if (emailParaAprovar.equals(user.getEmail()) &&
                                    senhaParaAprovar.equals(user.getSenha())){
                                exibirMenuUsuario(user, bd);
                                System.out.println();
                            }else{
                                System.out.println();
                                System.out.println("Usuário inválido");
                                System.out.println();
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }while(opt != 0);

        sc.close();
    }
    private static void exibirMenuUsuario(Usuario usuario, BancoDeDados bd){
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("BEM-VINDO " + usuario.getNome());
            System.out.println("1. Ver catálogo de livros");
            System.out.println("2. Ver Perfil");
            System.out.println("3. Total a pagar");
            System.out.println("0. Sair");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt){
                case 1:
                    System.out.println("=========================");
                    bd.mostrarLivros();
                    System.out.println("=========================");
                    System.out.println("Escolher livro para alugar: (exit para sair)");
                    String nomeLivro = sc.nextLine();
                    if (nomeLivro.equals("exit")){
                        continue;
                    }
                    else{
                        for (Livro l : bd.getLivros()){
                            if (l.getName().contains(nomeLivro) || l.getName().equals(nomeLivro)){
                                usuario.addLivro(l);
                                System.out.println("Você alugou " + l.getName());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println(usuario);
                    break;
                case 3:
                    System.out.println("Total a pagar: " + usuario.calcularPagamento());
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
            }
        }while (opt != 0);
    }
}