package br.com.viniProgramando.mvc.mybank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String nome;
    private String cpf;
    
    @JoinColumn(unique=true)
    private String username;
    @JoinColumn(unique=true)
    @OneToOne
    private Conta conta;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
    	cpf = cpf.trim();
//    	if(ValidaCPF.isCPF(cpf)) {
//    		this.cpf = cpf;}
    	//Criar exceção
    	this.cpf = cpf;
    }
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    

}
