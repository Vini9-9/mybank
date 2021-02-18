package br.com.viniProgramando.mvc.mybank.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	static Conta findContaByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
