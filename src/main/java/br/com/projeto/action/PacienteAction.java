package br.com.projeto.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.projeto.model.Paciente;
import br.com.projeto.service.PacienteService;

public class PacienteAction extends ActionSupport {

	private static final long serialVersionUID = -6173234665157181908L;

	private String idPaciente;

	private Paciente paciente;

	private String parametroPesquisa;

	private List<Paciente> pacientes = new ArrayList<Paciente>();

	@Autowired
	private PacienteService pacienteService;

	public String listar() {
		this.pacientes = this.pacienteService.pesquisarPacientesPorNome("");
		return SUCCESS;
	}

	public String cadastrar() {
		return SUCCESS;
	}

	public String salvar() {
		pacienteService.salvar(paciente);
		addActionMessage("Sucesso!");
		return SUCCESS;
	}

	public String editar() {
		this.paciente = this.pacienteService.pesquisarPacientePorId(Long.parseLong(this.idPaciente));
		return SUCCESS;
	}

	public String excluir() {
		this.pacienteService.deletar(Long.parseLong(this.idPaciente));
		addActionMessage("Usuário excluído com sucesso!");
		this.pacientes = this.pacienteService.pesquisarPacientesPorNome("");
		return SUCCESS;
	}

	public String pesquisar() {
		this.pacientes = this.pacienteService.pesquisarPacientesPorNome(this.parametroPesquisa);
		return SUCCESS;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}

}