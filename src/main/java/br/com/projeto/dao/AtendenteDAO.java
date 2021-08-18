package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.model.Atendente;

public interface AtendenteDAO {

	public void salvar(Atendente atendente);

	public void deletar(Long idAtendente);

	public Atendente pesquisarAtendentePorId(Long idAtendente);

	public List<Atendente> pesquisarAtendentesPorNome(String nome);

}
