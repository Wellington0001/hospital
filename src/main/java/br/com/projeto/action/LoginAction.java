package br.com.projeto.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import br.com.projeto.model.Usuario;
import br.com.projeto.service.UsuarioService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String perfil;

	private String login;

	private String senha;

	@Autowired
	private UsuarioService usuarioService;

	public String execute() throws Exception {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession sessao = request.getSession();

		Usuario usuario = this.usuarioService.pesquisarUsuarioPorLoginSenha(this.perfil, this.login, this.senha);

		if (usuario == null) {
			addActionError("Login ou senha inválida!");
			return ERROR;
		} else {
			sessao.setAttribute("usuarioLogado", usuario);
			sessao.setAttribute("perfil", this.perfil);
			return SUCCESS;
		}
	}

	public String loginMedico() {
		return SUCCESS;
	}

	public String sair() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession sessao = request.getSession();

		sessao.setAttribute("usuarioLogado", null);
		return SUCCESS;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}