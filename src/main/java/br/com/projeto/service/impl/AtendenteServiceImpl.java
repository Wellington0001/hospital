package br.com.projeto.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AtendenteDAO;
import br.com.projeto.model.Atendente;
import br.com.projeto.service.AtendenteService;

public class AtendenteServiceImpl implements AtendenteService {

	@Autowired
	private AtendenteDAO atendenteDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Atendente atendente) {
		this.atendenteDAO.salvar(atendente);
	}

	public Atendente pesquisarAtendentePorId(Long atendenteId) {
		return atendenteDAO.pesquisarAtendentePorId(atendenteId);
	}

	public void deletar(Long idAtendente) throws HibernateException {
		atendenteDAO.deletar(idAtendente);
	}

	public List<Atendente> pesquisarAtendentesPorNome(String nome) {
		return atendenteDAO.pesquisarAtendentesPorNome(nome);
	}

}
