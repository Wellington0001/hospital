package br.com.projeto.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.PacienteDAO;
import br.com.projeto.model.Paciente;
import br.com.projeto.service.PacienteService;

public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteDAO pacienteDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Paciente paciente) {
		this.pacienteDAO.salvar(paciente);
	}

	public Paciente pesquisarPacientePorId(Long pacienteId) {
		return pacienteDAO.pesquisarPacientePorId(pacienteId);
	}

	public void deletar(Long idPaciente) throws HibernateException {
		pacienteDAO.deletar(idPaciente);
	}

	public List<Paciente> pesquisarPacientesPorNome(String nome) {
		return pacienteDAO.pesquisarPacientesPorNome(nome);
	}

}
