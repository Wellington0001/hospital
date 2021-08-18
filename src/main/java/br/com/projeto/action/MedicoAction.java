package br.com.projeto.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.projeto.model.Medico;
import br.com.projeto.service.MedicoService;

public class MedicoAction extends ActionSupport {

	private static final long serialVersionUID = -6173234665157181908L;

	private String idMedico;

	private Medico medico;

	private String parametroPesquisa;

	private List<Medico> medicos = new ArrayList<Medico>();

	@Autowired
	private MedicoService medicoService;

	public String listar() {
		this.medicos = this.medicoService.pesquisarMedicosPorNome("");
		return SUCCESS;
	}

	public String cadastrar() {
		return SUCCESS;
	}

	public String salvar() {
		medicoService.salvar(medico);
		addActionMessage("Sucesso!");
		return SUCCESS;
	}

	public String editar() {
		this.medico = this.medicoService.pesquisarMedicoPorId(Long.parseLong(this.idMedico));
		return SUCCESS;
	}

	public String excluir() {
		this.medicoService.deletar(Long.parseLong(this.idMedico));
		addActionMessage("Usuário excluído com sucesso!");
		this.medicos = this.medicoService.pesquisarMedicosPorNome("");
		return SUCCESS;
	}

	public String pesquisar() {
		this.medicos = this.medicoService.pesquisarMedicosPorNome(this.parametroPesquisa);
		return SUCCESS;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}

}