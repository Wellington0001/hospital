package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.model.Consulta;

public interface ConsultaDAO {

	public void salvar(Consulta consulta);

	public void deletar(Long idConsulta);

	public Consulta pesquisarConsultaPorId(Long idConsulta);

	public List<Consulta> pesquisarConsultasPorPaciente(String nome);

}
