package br.com.viniProgramando.mvc.mybank.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import br.com.viniProgramando.mvc.mybank.model.Movimentacao;

public interface MovimentacoesRepository extends JpaRepository<Movimentacao, Long>{


	
}
