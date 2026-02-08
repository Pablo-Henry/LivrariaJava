/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava.Biblioteca;
import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo.hfmartins
 */
public class Biblioteca {
    public static final int MAX_LIVROS_POR_USUARIO = 5;
    public static final double MULTA_DIARIA = 2.0;
    public static final int MAXIMO_DIAS_DEVOLUCAO = 30;
    
    

    public static void main(String[] args) {
//        Usuario user = new Usuario("Jao", 20, 5);
        Usuario user = new Usuario(JOptionPane.showInputDialog(null, "Digite seu nome"), Integer.parseInt(JOptionPane.showInputDialog(null, "Idade")));

//        Livro livro = new Livro("Se beber não case", "Dicaprio");
        List <Livro> listaLivros = new ArrayList<>();
        Livro livro = new Livro(JOptionPane.showInputDialog(null, "Titulo:"), JOptionPane.showInputDialog(null, "Autor:"));
        Livro livro2 = new Livro(JOptionPane.showInputDialog(null, "Titulo:"), JOptionPane.showInputDialog(null, "Autor:"));
        Livro livro3 = new Livro(JOptionPane.showInputDialog(null, "Titulo:"), JOptionPane.showInputDialog(null, "Autor:"));
        listaLivros.add(livro);
        listaLivros.add(livro2);
        listaLivros.add(livro3);
        
        user.apresentar();
        

        while( true ) {
            JOptionPane.showMessageDialog(null, "Escolha uma das opções abaixo");
            String escolha = JOptionPane.showInputDialog(null, "emprestar | devolver | sair").toLowerCase();

            if (escolha.equals("emprestar")){
                if ( user.getQtdLivrosEmprestados() > Biblioteca.MAX_LIVROS_POR_USUARIO ) {
                    System.out.println("Limite Excedido!");
                    break;
            } else {
                    if (!listaLivros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, listaLivros.toString());
                        String escolhaLivro = JOptionPane.showInputDialog(null, "Digite o nome do titulo que deseja").toLowerCase();
                        boolean livroEncontrado = false;

                        for ( Livro l : listaLivros ){
                            if (escolhaLivro.equals(l.getTitulo().toLowerCase()) && l.getDisponivel() == true) {
                                livroEncontrado = true;
                                l.emprestar();
                                user.adicionarLivro(l);
                                JOptionPane.showMessageDialog(null, "Livro: " + l.getTitulo() + " Emprestado com sucesso! :P");
                               
                                listaLivros.removeIf(l2 -> {
                                    if (!l2.getDisponivel()) {
                                        l2.setDisponivel(true);
                                        return true; //remove o livro caso disponivel seja false
                                    } else {
                                        return false; //não remove caso seja true
                                    }
                                });
                                
                                break;

                            } 
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os Livros foram alugados! >_<");
                    }
                }
                //DEVOLVER
            } else if (escolha.equals("devolver")) {
                if ( !user.getLivrosEmprestados().isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Livros em sua posse: " + user.getLivrosEmprestados());
                    String escolhaLivroDevolucao = JOptionPane.showInputDialog(null, "Digite o livro que deseja devolver").toLowerCase();
                    boolean livroEncontradoDevolucao = false;
                    for (Livro l3 : user.getLivrosEmprestados()){
                        if ( l3.getTitulo().equals(escolhaLivroDevolucao) ) {
                            livroEncontradoDevolucao = true;
                            l3.devolver();
                            user.getLivrosEmprestados().remove(l3);
                            listaLivros.add(l3);
                            JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso :P ! Livros em sua posse: " + user.getLivrosEmprestados() );

                            //CÁLCULO MULTA
                            long dias = ChronoUnit.DAYS.between(l3.dataEmprestimo(), l3.dataDevolucao());
                            if ( dias > Biblioteca.MAXIMO_DIAS_DEVOLUCAO ){
                                int diasDeAtraso = Biblioteca.MAXIMO_DIAS_DEVOLUCAO - (int) dias;
                                double valorMulta = diasDeAtraso * Biblioteca.MULTA_DIARIA;
                                JOptionPane.showMessageDialog(null,   String.format("%d dias de atraso na devolução. Valor da Multa por atraso: R$ %.2f", diasDeAtraso, valorMulta));
                            } else {
                                int diasDeAtraso = 0;
                                double valorMulta = 0.0;
                                JOptionPane.showMessageDialog(null,  String.format("%d dias de atraso na devolução. Valor da Multa por atraso: R$ %.2f", diasDeAtraso, valorMulta));
                            }
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você não possui nenhum livro alugado :3");
                }
                //  SAIR
            }  else if (escolha.equals("sair")){
                JOptionPane.showMessageDialog(null,"Até logo :)");
                break;
                // OPÇÃO INVÁLIDA
            } else {
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA >_<");
            }
        }
    }
}
