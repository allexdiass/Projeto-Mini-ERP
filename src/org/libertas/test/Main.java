package org.libertas.test;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.GrupoDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Grupo;

public class Main {

	public static void main(String[] args) {
		Cidade c = new Cidade();
		c.setCidade("Hopkinsville");
		c.setEstado("Kentucky");
		CidadeDao cdao = new CidadeDao();
		cdao.salvar(c);
		
		Grupo g = new Grupo();
		g.setGrupo("Torturas");
		GrupoDao gdao = new GrupoDao();
		gdao.salvar(g);
	}

}
