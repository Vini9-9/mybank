package br.com.viniProgramando.mvc.mybank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Movimentacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    private Conta contaPagador;
	@ManyToOne
	private Conta contaRecebedor;
    
    private String userPagador;
	private String userRecebedor;
	
    
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    
	private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;
    private String categoria;
    
	public Conta getContaPagador() {
		return contaPagador;
	}
	public void setContaPagador(Conta contaPagador) {
		this.contaPagador = contaPagador;
	}
	public Conta getContaRecebedor() {
		return contaRecebedor;
	}
	public void setContaRecebedor(Conta contaRecebedor) {
		this.contaRecebedor = contaRecebedor;
	}
	public String getUserPagador() {
		return userPagador;
	}
	public void setUserPagador(String userPagador) {
		this.userPagador = userPagador;
	}
	public String getUserRecebedor() {
		return userRecebedor;
	}
	public void setUserRecebedor(String userRecebedor) {
		this.userRecebedor = userRecebedor;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
    
    public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    

}
