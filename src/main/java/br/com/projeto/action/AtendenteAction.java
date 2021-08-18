package br.com.projeto.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.projeto.model.Atendente;
import br.com.projeto.service.AtendenteService;

public class AtendenteAction extends ActionSupport {

	private static final long serialVersionUID = -6173234665157181908L;

	private String idAtendente;

	private Atendente atendente;

	private String parametroPesquisa;

	private List<Atendente> atendentes = new ArrayList<Atendente>();

	@Autowired
	private AtendenteService atendenteService;

	public String listar() {
		this.atendentes = this.atendenteService.pesquisarAtendentesPorNome("");
		return SUCCESS;
	}

	public String cadastrar() {
		return SUCCESS;
	}

	public String salvar() {
		atendenteService.salvar(atendente);
		addActionMessage("Sucesso!");
		return SUCCESS;
	}

	public String editar() {
		this.atendente = this.atendenteService.pesquisarAtendentePorId(Long.parseLong(this.idAtendente));
		return SUCCESS;
	}

	public String excluir() {
		this.atendenteService.deletar(Long.parseLong(this.idAtendente));
		addActionMessage("Usuário excluído com sucesso!");
		this.atendentes = this.atendenteService.pesquisarAtendentesPorNome("");
		return SUCCESS;
	}

	public String pesquisar() {
		this.atendentes = this.atendenteService.pesquisarAtendentesPorNome(this.parametroPesquisa);
		return SUCCESS;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

	public String getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(String idAtendente) {
		this.idAtendente = idAtendente;
	}

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}

}