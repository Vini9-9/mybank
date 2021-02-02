package br.com.viniProgramando.mvc.mybank.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.Movimentacao;
import br.com.viniProgramando.mvc.mybank.model.TipoConta;
import br.com.viniProgramando.mvc.mybank.model.TipoMovimentacao;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String name(Model model) {
		Cliente cliente = new Cliente();
		Conta conta = new Conta();
		Movimentacao movimentacao = new Movimentacao();
		conta.setTitular(cliente);
		cliente.setNome("Vinicius Pessoa da Silva");
		conta.setAgencia(458);
		conta.setNumero(769);
		conta.setTipoConta(TipoConta.Corrente);
		
		Conta contaRecebedora = new Conta();
		
		movimentacao.setContaPagador(conta);
		movimentacao.setContaRecebedor(contaRecebedora);
		movimentacao.setUserPagador("@suiciniv99");
		movimentacao.setUserRecebedor("@nelitek99");
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrasco");
		movimentacao.setValor(new BigDecimal(50.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAÍDA);
		
		//header
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("conta", conta);
		
		//body
		List<Movimentacao> movimentacoes = Arrays.asList(movimentacao);
		model.addAttribute("movimentacoes", movimentacoes);
		
		
		return "home";
	}
	
}
