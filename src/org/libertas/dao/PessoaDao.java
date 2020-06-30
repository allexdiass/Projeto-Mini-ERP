package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Pessoa;

public class PessoaDao {
	public void salvar(Pessoa p) {
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
	public List<Pessoa> listar() {
		List<Pessoa> lista = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			lista = session.createQuery("from Pessoa").getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Pessoa consultar(int idpessoa) {
		Pessoa p = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();
			p = (Pessoa) session.createQuery("from Pessoa where idpessoa = " + idpessoa).getSingleResult();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void excluir(int idpessoa) {
		Pessoa p = consultar(idpessoa);
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
