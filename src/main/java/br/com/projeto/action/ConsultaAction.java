package br.com.projeto.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.projeto.model.Consulta;
import br.com.projeto.model.Paciente;
import br.com.projeto.service.ConsultaService;
import br.com.projeto.service.PacienteService;

public class ConsultaAction extends ActionSupport {

	private static final long serialVersionUID = -6173234665157181908L;

	private String idConsulta;

	private Consulta consulta;

	private String parametroPesquisa;

	private List<Consulta> consultas = new ArrayList<Consulta>();

	private List<Paciente> pacientes = new ArrayList<Paciente>();

	@Autowired
	private ConsultaService consultaService;

	@Autowired
	private PacienteService pacienteService;

	public String listar() {
		this.consultas = this.consultaService.pesquisarConsultasPorPaciente("");
		return SUCCESS;
	}

	public String cadastrar() {
		this.pacientes = this.pacienteService.pesquisarPacientesPorNome("");
		return SUCCESS;
	}

	public String salvar() {
		consultaService.salvar(consulta);
		addActionMessage("Sucesso!");
		return SUCCESS;
	}

	public String editar() {
		this.pacientes = this.pacienteService.pesquisarPacientesPorNome("");
		this.consulta = this.consultaService.pesquisarConsultaPorId(Long.parseLong(this.idConsulta));
		return SUCCESS;
	}

	public String excluir() {
		this.consultaService.deletar(Long.parseLong(this.idConsulta));
		addActionMessage("Usuário excluído com sucesso!");
		this.consultas = this.consultaService.pesquisarConsultasPorPaciente("");
		return SUCCESS;
	}

	public String pesquisar() {
		this.consultas = this.consultaService.pesquisarConsultasPorPaciente(this.parametroPesquisa);
		return SUCCESS;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}