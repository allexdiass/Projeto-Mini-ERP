package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Produto;

public class ProdutoDao {
	public void salvar(Produto p) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(p);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		List<Produto> lista = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			lista = session.createQuery("from Produto").getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Produto consultar(int idproduto) {
		Produto p = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			p = (Produto) session.createQuery("from Produto where idproduto = " + idproduto).getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void excluir(int idproduto) {
		Produto p = consultar(idproduto);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(p);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
