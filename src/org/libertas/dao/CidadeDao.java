package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Cidade;

public class CidadeDao {
	public void salvar(Cidade c) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(c);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listar() {
		List<Cidade> lista = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			lista = session.createQuery("from Cidade").getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cidade consultar(int idcidade) {
		Cidade c = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			c = (Cidade) session.createQuery("from Cidade where idcidade = " + idcidade).getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public void excluir(int idcidade) {
		Cidade c = consultar(idcidade);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(c);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
