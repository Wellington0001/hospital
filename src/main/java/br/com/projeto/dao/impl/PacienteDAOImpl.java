package br.com.projeto.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.PacienteDAO;
import br.com.projeto.model.Paciente;

public class PacienteDAOImpl implements PacienteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public void salvar(Paciente paciente) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(paciente);
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
	public void deletar(Long idPaciente) {

		Session session = null;

		Paciente paciente = pesquisarPacientePorId(idPaciente);

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(paciente);
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
	public Paciente pesquisarPacientePorId(Long idPaciente) {
		return (Paciente) sessionFactory.getCurrentSession().get(Paciente.class, idPaciente);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Paciente> pesquisarPacientesPorNome(String nome) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Paciente as paciente where upper(paciente.nome) like upper(:nome) order by paciente.nome")
				.setString("nome", "%" + nome + "%").list();
	}

}
