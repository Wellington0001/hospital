package br.com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Usuario {

	@Column(name = "especialidade")
	private String especialidade;

	@Column(name = "crm")
	private String crm;

	public Medico() {
		super();
	}

	public Medico(Long id, String nome, String login, String senha) {
		super(id, nome, login, senha);
	}

	public Medico(String especialidade, String crm) {
		super();
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "Medico [especialidade=" + especialidade + ", crm=" + crm + "]";
	}

}
