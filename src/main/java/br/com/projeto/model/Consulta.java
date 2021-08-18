package br.com.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_medico", referencedColumnName = "id")
	private Medico medico;

	@Column(name = "data_consulta")
	private Date dataConsulta = new Date();

	@Column(name = "registro_consulta")
	private String registroConsulta;

	public Consulta() {
		super();
	}

	public Consulta(Long id, Paciente paciente, Medico medico, Date dataConsulta, String registroConsulta) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.dataConsulta = dataConsulta;
		this.registroConsulta = registroConsulta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getRegistroConsulta() {
		return registroConsulta;
	}

	public void setRegistroConsulta(String registroConsulta) {
		this.registroConsulta = registroConsulta;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", dataConsulta=" + dataConsulta
				+ ", registroConsulta=" + registroConsulta + "]";
	}

}
