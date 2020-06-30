package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.GrupoDao;
import org.libertas.pojo.Grupo;

public class SalvarGrupo implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getParameter("idgrupo")==null) return "idgrupo obrigatorio";
			if (req.getParameter("grupo")==null || req.getParameter("grupo").trim().isEmpty()) return "grupo obrigatorio";
			
			Grupo g = new Grupo();
			g.setIdgrupo(Integer.parseInt(req.getParameter("idgrupo")));
			g.setGrupo(req.getParameter("grupo"));
			GrupoDao gdao = new GrupoDao();
			gdao.salvar(g);
			if (g.getIdgrupo()>0) {
				return "Registro alterado com sucesso";
			} else {
				return "Registro salvo com sucesso";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
