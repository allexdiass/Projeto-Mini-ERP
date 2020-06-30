package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.pojo.Cidade;

import com.google.gson.Gson;

public class ListarCidades implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			CidadeDao cdao = new CidadeDao();
			List<Cidade> lista = cdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
