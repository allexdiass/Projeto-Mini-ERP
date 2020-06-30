package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.GrupoDao;
import org.libertas.dao.ProdutoDao;
import org.libertas.pojo.Grupo;
import org.libertas.pojo.Produto;

public class SalvarProduto implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getParameter("idproduto")==null) return "idproduto obrigatorio";
			if (req.getParameter("descricao")==null || req.getParameter("descricao").trim().isEmpty()) return "descricao obrigatoria";
			
			
			Produto p = new Produto();
			p.setIdproduto(Integer.parseInt(req.getParameter("idproduto")));
			p.setDescricao(req.getParameter("descricao"));
			p.setPreco(Double.parseDouble(req.getParameter("preco")));
			
			GrupoDao gdao = new GrupoDao();
			Grupo g = gdao.consultar(Integer.parseInt(req.getParameter("grupo")));
			
			p.setGrupo(g);
			
			ProdutoDao pdao = new ProdutoDao();
			pdao.salvar(p);
			if (p.getIdproduto()>0) {
				return "Registro alterado com sucesso";
			} else {
				return "Registro salvo com sucesso";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
