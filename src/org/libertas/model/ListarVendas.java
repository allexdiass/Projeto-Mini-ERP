package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ListarVendas implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			VendaDao vdao = new VendaDao();
			List<Venda> lista = vdao.listar();
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
;
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
