/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicasjava.Biblioteca;

/**
 *
 * @author pablo.hfmartins
 */
public abstract class Funcionario implements Pagamento {
    private String nome;
    private double salario;
    private String cargo;
    
    private double pagamentoComBonus = processarPagamento();
    private double bonus = calcularBonus();
    private double salarioSemBonus = getSalario();
    
    public Funcionario(String nome, double salario, String cargo){
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    };

    
    //GETTER AND SETTERS
    public String getCargo() {
        return cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPagamentoComBonus() {
        return pagamentoComBonus;
    }

    public void setPagamentoComBonus(double pagamentoComBonus) {
        this.pagamentoComBonus = pagamentoComBonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalarioSemBonus() {
        return salarioSemBonus;
    }

    public void setSalarioSemBonus(double salarioSemBonus) {
        this.salarioSemBonus = salarioSemBonus;
    }
    
    
    
    

    
    //METHODS
    public abstract double calcularBonus();
    
    public void mostrarDados(){
        System.out.printf("Nome: %s | Salario sem bonus: %.2f | Salario com bonus: %.2f%n%n", getNome(), getSalario(), processarPagamento());
    };
    
    @Override
     public double processarPagamento(){
         double novoSalario = this.getSalario() + calcularBonus();
         this.setSalario(novoSalario);
         return this.getSalario();
     };
     
    
    
}
