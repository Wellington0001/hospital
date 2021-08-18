package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.model.Paciente;

public interface PacienteDAO {

	public void salvar(Paciente paciente);

	public void deletar(Long idPaciente);

	public Paciente pesquisarPacientePorId(Long idPaciente);

	public List<Paciente> pesquisarPacientesPorNome(String nome);

}
