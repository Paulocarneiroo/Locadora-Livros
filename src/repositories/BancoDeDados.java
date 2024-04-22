package repositories;

import entidades.Livro;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    List<Usuario> usuarios = new ArrayList<>();
    List<Livro> livros = new ArrayList<>();

    public BancoDeDados(){
        livros.add(new Livro("Harry Potter", 30));
        livros.add(new Livro("Percy Jackson e os Heróis do Olimpo", 40));
        livros.add(new Livro("Inteligência Humilhada", 65));
        livros.add(new Livro("As Crônicas de Nárnia", 60));
        livros.add(new Livro("Cartas de um Diabo a seu Aprendiz", 53));
        livros.add(new Livro("Cristianismo puro e simples ", 42));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void mostrarLivros(){
        for (Livro l : livros){
            System.out.println("Nome: " + l.getName() + " Preço: " + l.getPrice());
        }
    }
}
