package br.com.projeto.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.ConsultaDAO;
import br.com.projeto.model.Consulta;

public class ConsultaDAOImpl implements ConsultaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public void salvar(Consulta consulta) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(consulta);
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
	public void deletar(Long idConsulta) {

		Session session = null;

		Consulta consulta = pesquisarConsultaPorId(idConsulta);

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(consulta);
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
	public Consulta pesquisarConsultaPorId(Long idConsulta) {
		return (Consulta) sessionFactory.getCurrentSession().get(Consulta.class, idConsulta);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Consulta> pesquisarConsultasPorPaciente(String nome) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Consulta as consulta where upper(consulta.paciente.nome) like upper(:nome) order by consulta.dataConsulta, consulta.paciente.nome")
				.setString("nome", "%" + nome + "%").list();
	}

}
