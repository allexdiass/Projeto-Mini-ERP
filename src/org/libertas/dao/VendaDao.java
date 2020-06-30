package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Venda;

public class VendaDao {
	public void salvar(Venda v) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(v);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		List<Venda> lista = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			lista = session.createQuery("from Venda").getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Venda consultar(int idvenda) {
		Venda v = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			v = (Venda) session.createQuery("from Venda where idvenda = " + idvenda).getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public void excluir(int idvenda) {
		Venda v = consultar(idvenda);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(v);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
