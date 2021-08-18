package br.com.projeto.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import br.com.projeto.model.Usuario;

public class AutorizacaoInterceptor implements Interceptor {

	private static final long serialVersionUID = -3246368767194388692L;

	public void init() {
	}

	public String intercept(ActionInvocation ai) throws Exception {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if (usuario == null) {
			sessao.invalidate();
			return "usuarioNaoLogado";
		}

		sessao.setAttribute("usuarioLogado", usuario);
		return ai.invoke();
	}

	public void destroy() {
	}

}
