package br.com.viniProgramando.mvc.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.TipoConta;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String name(Model model) {
		Cliente cliente = new Cliente();
		Conta conta = new Conta();
		conta.setTitular(cliente);
		cliente.setNome("Vinicius Pessoa da Silva");
		conta.setAgencia(458);
		conta.setNumero(769);
		conta.setTipoConta(TipoConta.Corrente);
		model.addAttribute("cliente", cliente);
		model.addAttribute("conta", conta);
		return "home";
	}
	
}
