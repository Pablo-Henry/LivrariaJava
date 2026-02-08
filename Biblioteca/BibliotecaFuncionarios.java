package logicasjava.Biblioteca;

import javax.swing.*;

public class BibliotecaFuncionarios {
    public static void main(String[] args) {
        ////        Funcionario gerente = new Gerente("Carlos", 8000);
        Funcionario gerente = new Gerente(JOptionPane.showInputDialog(null, "Nome Gerente:"), Integer.parseInt(JOptionPane.showInputDialog("Sal�rio Gerente:")), JOptionPane.showInputDialog(null, "Cargo:"));


////        Funcionario bibliotecario = new Bibliotecario("Cibelly", 2534.24);
        Funcionario bibliotecario = new Bibliotecario(JOptionPane.showInputDialog(null, "Nome Bibliotec�rio:"), Integer.parseInt(JOptionPane.showInputDialog("Sal�rio Bibliotec�rio:")), JOptionPane.showInputDialog(null, "Cargo:"));

        gerente.mostrarDados();
        bibliotecario.mostrarDados();
    }
}
