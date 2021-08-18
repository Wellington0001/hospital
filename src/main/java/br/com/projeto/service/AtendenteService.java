package br.com.projeto.service;

import java.util.List;

import br.com.projeto.model.Atendente;

public interface AtendenteService {

	public void salvar(Atendente atendente);

	public void deletar(Long idAtendente);

	public Atendente pesquisarAtendentePorId(Long idAtendente);

	public List<Atendente> pesquisarAtendentesPorNome(String nome);

}
