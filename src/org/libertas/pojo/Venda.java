package org.libertas.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="venda")
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idvenda;
	@OneToOne
	private Pessoa pessoa;
	@ManyToOne
	private Produto produto;
	@Column
	private double quantidade;
	@Column 
	private double valorUnitario;
	@Column
	private double valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	public Venda() {
		this.idvenda = 0;
		this.pessoa = new Pessoa();
		this.quantidade = 0.0;
		this.valorUnitario = 0.0;
		this.valorTotal = 0.0;
		this.data = new Date();
		this.produto = new Produto();
	}

	public int getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
