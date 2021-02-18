package br.com.viniProgramando.mvc.mybank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.viniProgramando.mvc.mybank.model.Cliente;
import br.com.viniProgramando.mvc.mybank.model.Conta;
import br.com.viniProgramando.mvc.mybank.model.Movimentacao;
import br.com.viniProgramando.mvc.mybank.model.TipoMovimentacao;
import br.com.viniProgramando.mvc.mybank.repository.ClienteRepository;
import br.com.viniProgramando.mvc.mybank.repository.ContaRepository;

public class RequisicaoNovoPagamento {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	
	private String nomeUsuario;
	private String valorPagamento;
	private String categoria;
	private String descricao;
	private String formaPagamento;
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(String valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Movimentacao toMovimentacao(Conta conta,Conta contaRecebedora) {
		

		Movimentacao movimentacao = new Movimentacao();
		 movimentacao.setContaPagador(conta);
		 movimentacao.setContaRecebedor(contaRecebedora);
		 movimentacao.setUserPagador("suiciniv99");
		 
		 movimentacao.setUserRecebedor(nomeUsuario);
		 movimentacao.setData(LocalDateTime.now());
		 movimentacao.setDescricao(descricao); 
		 movimentacao.setCategoria(categoria);
		 movimentacao.setValor(new BigDecimal(valorPagamento));
		 movimentacao.setTipoMovimentacao(TipoMovimentacao.SAÍDA);
		return null;
	}
	

}
