package br.com.projeto.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AtendenteDAO;
import br.com.projeto.model.Atendente;

public class AtendenteDAOImpl implements AtendenteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public void salvar(Atendente atendente) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(atendente);
			session.getTransaction().commit();
		} catch (HibernateException hex) {
			if (session != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw hex;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Transactional
	@Override
	public void deletar(Long idAtendente) {

		Session session = null;

		Atendente atendente = pesquisarAtendentePorId(idAtendente);

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(atendente);
			session.getTransaction().commit();
		} catch (HibernateException hex) {
			if (session != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw hex;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Transactional
	@Override
	public Atendente pesquisarAtendentePorId(Long idAtendente) {
		return (Atendente) sessionFactory.getCurrentSession().get(Atendente.class, idAtendente);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Atendente> pesquisarAtendentesPorNome(String nome) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Atendente as atendente where upper(atendente.nome) like upper(:nome) order by atendente.nome")
				.setString("nome", "%" + nome + "%").list();
	}

}
