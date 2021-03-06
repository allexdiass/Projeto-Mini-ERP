package org.libertas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idpessoa;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String bairro;
	@Column
	private String telefone;
	@OneToOne
	private Cidade cidade;
	
	public Pessoa() {
		this.idpessoa = 0;
		this.nome = "";
		this.endereco = "";
		this.bairro = "";
		this.telefone = "";
		this.cidade = new Cidade();
	}

	public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
