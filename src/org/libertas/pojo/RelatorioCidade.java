package org.libertas.pojo;

public class RelatorioCidade {
	private int idcidade;
	private String cidade;
	private double quantidade;
	private double total;
	
	public RelatorioCidade() {
		this.idcidade = 0;
		this.cidade = "";
		this.quantidade = 0.0;
		this.total = 0.0;
	}

	public int getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
