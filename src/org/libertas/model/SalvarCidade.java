package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.pojo.Cidade;

public class SalvarCidade implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getParameter("idcidade")==null) return "idcidade invalido";
			if (req.getParameter("cidade")==null || req.getParameter("cidade").trim().isEmpty()) return "cidade obrigatoria";
			
			Cidade c = new Cidade();
			c.setIdcidade(Integer.parseInt(req.getParameter("idcidade")));
			c.setCidade(req.getParameter("cidade"));
			c.setEstado(req.getParameter("estado"));
			CidadeDao cdao = new CidadeDao();
			cdao.salvar(c);
			if (c.getIdcidade()>0) {
				return "Registro alterado com sucesso";
			} else {
				return "Registro salvo com sucesso";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
