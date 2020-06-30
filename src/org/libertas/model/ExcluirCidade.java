package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;

public class ExcluirCidade implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		int idcidade = Integer.parseInt(req.getParameter("idcidade"));
		CidadeDao cdao = new CidadeDao();
		cdao.excluir(idcidade);
		return "Cidade Excluida com sucesso!";
	}
}
