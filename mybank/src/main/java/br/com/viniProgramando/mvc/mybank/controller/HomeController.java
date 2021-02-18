package br.com.viniProgramando.mvc.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.Movimentacao;
import br.com.viniProgramando.mvc.mybank.repository.ClienteRepository;
import br.com.viniProgramando.mvc.mybank.repository.ContaRepository;
import br.com.viniProgramando.mvc.mybank.repository.MovimentacoesRepository;

@Controller
public class HomeController {
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping("/home")
	public String name(Model model) {
		
		//header
		List<Cliente> clienteDto = clienteRepository.findAll();
		List<Conta> contaDto = contaRepository.findAll();
		Cliente meuCliente = clienteDto.get(0);
		Conta minhaConta= contaDto.get(0);
		model.addAttribute("cliente", meuCliente); 
		model.addAttribute("conta", minhaConta);
		
		
		//body
		List<Movimentacao> movimentacoes = movimentacoesRepository.findAll();
		model.addAttribute("movimentacoes", movimentacoes);
		
		
		return "home";
	}
	
}
