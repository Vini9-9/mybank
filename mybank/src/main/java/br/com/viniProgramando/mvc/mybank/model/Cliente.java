package br.com.viniProgramando.mvc.mybank.model;


public class Cliente {

    private String nome;
    private String cpf;


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
    

}
