package org.libertas.pojo;

public class RelatorioGrupo {
	private int idgrupo;
	private String grupo;
	private double quantidade;
	private double total;
	
	public RelatorioGrupo() {
		this.idgrupo = 0;
		this.grupo = "";
		this.quantidade = 0.0;
		this.total = 0.0;
	}

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
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
