package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.GrupoDao;
import org.libertas.pojo.Grupo;

import com.google.gson.Gson;

public class ListarGrupos implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			GrupoDao gdao = new GrupoDao();
			List<Grupo> lista = gdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
