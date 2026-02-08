/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava.Biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo.hfmartins
 */
public class Usuario {
    private String nome;
    private int idade;
    
    private int qtdLivrosEmprestados;
    private List<Livro> livrosEmprestados = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    
    public Usuario(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.qtdLivrosEmprestados = 0;
    };
    
    //GETER AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQtdLivrosEmprestados() {
        return qtdLivrosEmprestados;
    }

    public void setQtdLivrosEmprestados(int newQtdLivrosEmprestados) {
        this.qtdLivrosEmprestados = newQtdLivrosEmprestados;
    }
    

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
//METHODS
    
    public void apresentar(){
        
        if (this.qtdLivrosEmprestados > 5) {
            System.out.printf("Nome: %s | Idade: %d%n%n ", getNome(), getIdade());
        } else {
            System.out.printf("Nome: %s | Idade: %d | Quantidade de Livros Emprestados: %d%n%n", getNome(), getIdade(), getQtdLivrosEmprestados());
        }
    };

    public int adicionarLivro(Livro livro){
        this.livrosEmprestados.add(livro);
        return qtdLivrosEmprestados++;
    }
    
    public static void adicionarUsuario(Usuario u){
        listaUsuarios.add(u);
    }
    
    public static List<Usuario> listarUsuarios(){
        return listaUsuarios;
    }
    
    @Override
    public String toString(){
        return getNome();
    }

    
}
