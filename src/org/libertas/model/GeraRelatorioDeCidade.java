package org.libertas.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.RelatorioCidade;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeraRelatorioDeCidade implements Modelo {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try {
			VendaDao vdao = new VendaDao();
			ArrayList<Venda> lista = new ArrayList<Venda>();
			lista.addAll(vdao.listar());
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			ArrayList<RelatorioCidade> listaRelatorio = new ArrayList<RelatorioCidade>();
			for (Venda venda : lista) {
				boolean achou = false;
				for (RelatorioCidade r : listaRelatorio) {
					if (venda.getPessoa().getCidade().getIdcidade() == r.getIdcidade()) {
						double valortotal = r.getTotal();
						r.setTotal(venda.getValorTotal()+valortotal);
						double qtd = r.getQuantidade();
						r.setQuantidade(venda.getQuantidade()+qtd);
						achou = true;
						break;
					}
				}
				if (!achou) {
					RelatorioCidade r = new RelatorioCidade();
					r.setIdcidade(venda.getPessoa().getCidade().getIdcidade());
					r.setCidade(venda.getPessoa().getCidade().getCidade());
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
