package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Livro> livrosAlugados = new ArrayList<>();

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

    public void addLivro(Livro livro){
        livrosAlugados.add(livro);
    }

    @Override
    public String toString() {
        if (livrosAlugados.isEmpty()){
            return "Nome: " + nome + '\n'
                    + "Email: " + email;
        }else{
            return "Nome: " + nome + "," + '\n'
                    + "Email: " + email + "," + '\n'
                    + "Livros Alugados: " + livrosAlugados;
        }
    }

    public Double calcularPagamento(){
        double sum = 0;
        for (Livro l : livrosAlugados){
            sum += l.getPrice();
        }
        return sum;
    }
}
