package br.com.projeto.service;

import java.util.List;

import br.com.projeto.model.Medico;

public interface MedicoService {

	public void salvar(Medico medico);

	public void deletar(Long idMedico);

	public Medico pesquisarMedicoPorId(Long idMedico);

	public List<Medico> pesquisarMedicosPorNome(String nome);

}
