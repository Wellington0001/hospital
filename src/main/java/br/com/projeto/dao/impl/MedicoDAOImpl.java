package br.com.projeto.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.MedicoDAO;
import br.com.projeto.model.Medico;

public class MedicoDAOImpl implements MedicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public void salvar(Medico medico) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(medico);
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
	public void deletar(Long idMedico) {

		Session session = null;

		Medico medico = pesquisarMedicoPorId(idMedico);

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(medico);
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
	public Medico pesquisarMedicoPorId(Long idMedico) {
		return (Medico) sessionFactory.getCurrentSession().get(Medico.class, idMedico);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Medico> pesquisarMedicosPorNome(String nome) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Medico as medico where upper(medico.nome) like upper(:nome) order by medico.nome")
				.setString("nome", "%" + nome + "%").list();
	}

}
