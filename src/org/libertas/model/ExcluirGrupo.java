package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.GrupoDao;

public class ExcluirGrupo implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		int idgrupo = Integer.parseInt(req.getParameter("idgrupo"));
		GrupoDao gdao = new GrupoDao();
		gdao.excluir(idgrupo);
		return "Grupo excluido com sucesso";
	}
}
