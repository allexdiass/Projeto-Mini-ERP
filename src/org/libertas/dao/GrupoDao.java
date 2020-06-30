package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Grupo;

public class GrupoDao {
	public void salvar(Grupo g) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(g);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listar() {
		List<Grupo> lista = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			lista = session.createQuery("from Grupo").getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Grupo consultar(int idgrupo) {
		Grupo g = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			g = (Grupo) session.createQuery("from Grupo where idgrupo = " + idgrupo).getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public void excluir(int idgrupo) {
		Grupo g = consultar(idgrupo);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			session.delete(g);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
