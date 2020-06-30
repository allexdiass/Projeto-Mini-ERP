package org.libertas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grupo")
public class Grupo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idgrupo;
	@Column
	private String grupo;
	
	public Grupo() {
		this.idgrupo = 0;
		this.grupo = "";
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
	
}
