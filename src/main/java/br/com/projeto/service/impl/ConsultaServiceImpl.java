package br.com.projeto.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.ConsultaDAO;
import br.com.projeto.model.Consulta;
import br.com.projeto.service.ConsultaService;

public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaDAO consultaDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(Consulta consulta) {
		this.consultaDAO.salvar(consulta);
	}

	public Consulta pesquisarConsultaPorId(Long consultaId) {
		return consultaDAO.pesquisarConsultaPorId(consultaId);
	}

	public void deletar(Long idConsulta) throws HibernateException {
		consultaDAO.deletar(idConsulta);
	}

	public List<Consulta> pesquisarConsultasPorPaciente(String nome) {
		return consultaDAO.pesquisarConsultasPorPaciente(nome);
	}

}
