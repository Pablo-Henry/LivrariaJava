/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava.Biblioteca;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author pablo.hfmartins
 */
public class ListaFuncionarios {
    
   private static List<Funcionario> listaFuncionarios = new ArrayList<>();
   
   public static void adicionar(Funcionario f){
       listaFuncionarios.add(f);
   }
   
   
    public static List<Funcionario> listar(){
        return listaFuncionarios;
    }
}
