package br.com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atendente")
public class Atendente extends Usuario {

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "periodo_trabalho")
	private String periodoTrabalho;

	public Atendente() {
		super();
	}

	public Atendente(Long id, String nome, String login, String senha) {
		super(id, nome, login, senha);
	}

	public Atendente(String telefone, String periodoTrabalho) {
		super();
		this.telefone = telefone;
		this.periodoTrabalho = periodoTrabalho;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPeriodoTrabalho() {
		return periodoTrabalho;
	}

	public void setPeriodoTrabalho(String periodoTrabalho) {
		this.periodoTrabalho = periodoTrabalho;
	}

	@Override
	public String toString() {
		return "Atendente [telefone=" + telefone + ", periodoTrabalho=" + periodoTrabalho + "]";
	}

}
