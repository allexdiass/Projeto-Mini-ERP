package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.PessoaDao;

public class ExcluirPessoa implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		int idpessoa = Integer.parseInt(req.getParameter("idpessoa"));
		PessoaDao pdao = new PessoaDao();
		pdao.excluir(idpessoa);
		return "Pessoa excluida com sucesso!";
	}
}
