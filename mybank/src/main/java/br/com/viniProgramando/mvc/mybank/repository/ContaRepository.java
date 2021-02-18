package br.com.viniProgramando.mvc.mybank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.Movimentacao;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	
}
