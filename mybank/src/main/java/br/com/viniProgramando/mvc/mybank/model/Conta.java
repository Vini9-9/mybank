package br.com.viniProgramando.mvc.mybank.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private double saldo;
    private int agencia;

	private int numero;
    @JoinColumn(unique=true)
    @OneToOne
    private Cliente titular;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    
//    private static int total = 0;

//    public Conta(int agencia, int numero){
//        Conta.total++;
//        System.out.println("O total de contas é " + Conta.total);
//        this.agencia = agencia;
//        this.numero = numero;
//        this.saldo = 100;
//        System.out.println("Estou criando uma conta " + this.numero);
//    }
    
    

    public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if(this.saca(valor)) {
        		destino.deposita(valor);
        		return true;
        } else {
        		return false;
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

	public TipoConta getTipoConta() {
		return tipoConta;
	}

    public Long getId() {
		return id;
	}
//    public static int getTotal(){
//        return Conta.total;
//    }

}