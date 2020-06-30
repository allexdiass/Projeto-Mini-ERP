package org.libertas.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.PessoaDao;
import org.libertas.dao.ProdutoDao;
import org.libertas.dao.VendaDao;
import org.libertas.pojo.Pessoa;
import org.libertas.pojo.Produto;
import org.libertas.pojo.Venda;

public class SalvarVenda implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getParameter("produto")==null) return "Produto obrigatorio";
			if (req.getParameter("quantidade")==null || req.getParameter("quantidade").trim().isEmpty()) return "Quantidade obrigatoria";
			
			Venda v = new Venda();
			PessoaDao pdao = new PessoaDao();
			Pessoa p = pdao.consultar(Integer.parseInt(req.getParameter("cliente")));
			v.setPessoa(p);
			ProdutoDao pddao = new ProdutoDao();
			Produto prod = pddao.consultar(Integer.parseInt(req.getParameter("produto")));
			v.setProduto(prod);
			double qtd = Double.parseDouble(req.getParameter("quantidade"));
			double vlr = Double.parseDouble(req.getParameter("vlrunitario"));
			v.setQuantidade(qtd);
			v.setValorUnitario(vlr);
			v.setValorTotal(qtd*vlr);
			v.setData(new Date());
			
			VendaDao vdao = new VendaDao();
			vdao.salvar(v);
			return "Venda realizada com sucesso";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
