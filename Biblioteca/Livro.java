
package logicasjava.Biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private boolean disponivel;
    
    private static int totalLivrosEmprestados = 0;
    private static List<Livro> listaLivros = new ArrayList<>();
    
    
    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    //GETERS AND SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
//METODOS
    
    public LocalDate dataEmprestimo(){
        LocalDate dataEmprestimo = LocalDate.of(2025, 12, 23);
        return dataEmprestimo;
    };
    
     public LocalDate dataDevolucao(){
        LocalDate dataDevolucao = LocalDate.now();
        return dataDevolucao;
    };
    
    public boolean emprestar(){
        if (disponivel) {
            dataEmprestimo();
            this.totalLivrosEmprestados++;
            this.setDisponivel(false);
        }
        return this.disponivel;
    };
    
    public boolean devolver(){
        if (disponivel == false) {
            dataDevolucao();
            this.totalLivrosEmprestados--;
            this.setDisponivel(true);
        }
        return this.disponivel;
        
    };
    
    @Override
    public String toString(){
        return this.getTitulo();
    };
    
    public static void adicionarLivro(Livro l){
        listaLivros.add(l);
    }
    
    public static List<Livro> mostraLivros(){
        return listaLivros;
    }
    
    @Override
    public int compareTo(Livro newLivro) {
        return this.getTitulo().compareTo(newLivro.getTitulo());
    }
    
}
