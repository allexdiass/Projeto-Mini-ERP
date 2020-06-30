package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.ProdutoDao;

public class ExcluirProduto implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		int idproduto = Integer.parseInt(req.getParameter("idproduto"));
		ProdutoDao pdao = new ProdutoDao();
		pdao.excluir(idproduto);
		return "Produto excluido com sucesso!";
	}
}
