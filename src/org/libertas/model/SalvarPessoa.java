package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.PessoaDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Pessoa;

public class SalvarPessoa implements Modelo {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getParameter("idpessoa")==null) return "idpessoa obrigatorio";
			if (req.getParameter("nome")==null || req.getParameter("nome").trim().isEmpty()) return "idpessoa obrigatorio";
		
			Pessoa p = new Pessoa();
			p.setNome(req.getParameter("nome"));
			p.setIdpessoa(Integer.parseInt(req.getParameter("idpessoa")));
			p.setBairro(req.getParameter("bairro"));
			p.setEndereco(req.getParameter("endereco"));
			p.setTelefone(req.getParameter("telefone"));
			
			CidadeDao cdao = new CidadeDao();
			Cidade c = cdao.consultar(Integer.parseInt(req.getParameter("cidade")));
			
			p.setCidade(c);
			
			PessoaDao pdao = new PessoaDao();
			pdao.salvar(p);
			if (p.getIdpessoa()>0) {
				return "Registro alterado com sucesso";
			} else {
				return "Registro salvo com sucesso";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
