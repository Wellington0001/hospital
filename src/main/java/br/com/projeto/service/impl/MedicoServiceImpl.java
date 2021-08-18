package br.com.projeto.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.MedicoDAO;
import br.com.projeto.model.Medico;
import br.com.projeto.service.MedicoService;

public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoDAO medicoDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Medico medico) {
		this.medicoDAO.salvar(medico);
	}

	public Medico pesquisarMedicoPorId(Long medicoId) {
		return medicoDAO.pesquisarMedicoPorId(medicoId);
	}

	public void deletar(Long idMedico) throws HibernateException {
		medicoDAO.deletar(idMedico);
	}

	public List<Medico> pesquisarMedicosPorNome(String nome) {
		return medicoDAO.pesquisarMedicosPorNome(nome);
	}

}
