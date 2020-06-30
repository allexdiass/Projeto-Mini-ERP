package org.libertas.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.RelatorioGrupo;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeraRelatorioDeGrupo implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			VendaDao vdao = new VendaDao();
			ArrayList<Venda> lista = new ArrayList<Venda>();
			lista.addAll(vdao.listar());
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			ArrayList<RelatorioGrupo> listaRelatorio = new ArrayList<RelatorioGrupo>();
			for (Venda venda : lista) {
				boolean achou = false;
				for (RelatorioGrupo r : listaRelatorio) {
					if (venda.getProduto().getGrupo().getIdgrupo() == r.getIdgrupo()) {
						double valortotal = r.getTotal();
						r.setTotal(venda.getValorTotal()+valortotal);
						double qtd = r.getQuantidade();
						r.setQuantidade(venda.getQuantidade()+qtd);
						achou = true;
						break;
					}
				}
				if (!achou) {
					RelatorioGrupo r = new RelatorioGrupo();
					r.setIdgrupo(venda.getProduto().getGrupo().getIdgrupo());
					r.setGrupo(venda.getProduto().getGrupo().getGrupo());
					r.setQuantidade(venda.getQuantidade());
					r.setTotal(venda.getValorTotal());
					listaRelatorio.add(r);
				}
			}
			
			String json = gson.toJson(listaRelatorio);
			return json;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
