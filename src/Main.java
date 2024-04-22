
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

                    Usuario usuario = new Usuario(name, email, senha);
                    bd.getUsuarios().add(usuario);

                    System.out.println("Cadastro realizado, bem-vindo " + usuario.getNome());
                    System.out.println();
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

                        for (Usuario user : bd.getUsuarios()){
                            if (emailParaAprovar.equals(user.getEmail()) &&
                                    senhaParaAprovar.equals(user.getSenha())){
                                user.exibirMenu(user);
                                System.out.println();
                            }else{
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

}