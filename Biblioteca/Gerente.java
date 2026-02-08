/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava.Biblioteca;

/**
 *
 * @author pablo.hfmartins
 */
public class Gerente extends Funcionario {
    public Gerente(String nome, double salario, String cargo){
        super(nome, salario, cargo);
    };
    
    
    @Override
     public double calcularBonus(){
         double bonus = getSalario() * 0.10;
         return bonus;
     };
     
//     @Override
//     public void mostrarDados(){
//        System.out.printf("Nome: %s | Salario: %.2f | Bonnus: %.2f%n%n", getNome(), getSalario(), calcularBonus());
//     };
     
}
