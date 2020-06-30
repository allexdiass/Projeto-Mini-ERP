package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.PessoaDao;
import org.libertas.pojo.Pessoa;

import com.google.gson.Gson;

public class ListarPessoas implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PessoaDao pdao = new PessoaDao();
			List<Pessoa> lista = pdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
