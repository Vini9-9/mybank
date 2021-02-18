package br.com.viniProgramando.mvc.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.viniProgramando.mvc.mybank.dto.RequisicaoNovoPagamento;
import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.Movimentacao;
import br.com.viniProgramando.mvc.mybank.repository.ClienteRepository;
import br.com.viniProgramando.mvc.mybank.repository.ContaRepository;
import br.com.viniProgramando.mvc.mybank.repository.MovimentacoesRepository;

@Controller
@RequestMapping("pagamento")
public class PagamentoController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@GetMapping("formulario")
	public String formulario(Model model) {
		List<Cliente> clienteDto = clienteRepository.findAll();
		Cliente meuCliente = clienteDto.get(0);
		model.addAttribute("cliente", meuCliente);
		return "pagamento/formulario";
	}
	
	@PostMapping("usuarios/novo")
	public String novo(RequisicaoNovoPagamento requisicao) {
		List<Cliente> clienteDto = clienteRepository.findAll();
		Cliente meuCliente = clienteDto.get(0);
		List<Conta> contaDto = contaRepository.findAll();
		Conta minhaConta2= contaDto.get(1);
		
		
		
		System.out.println(meuCliente.getConta());
		Conta minhaConta = meuCliente.getConta();
		System.out.println(minhaConta + " | " + minhaConta2);
		
		Movimentacao movimentacao = requisicao.toMovimentacao(minhaConta,minhaConta2);
		movimentacoesRepository.save(movimentacao);
		
		return "pagamento/formulario";
	}
}
