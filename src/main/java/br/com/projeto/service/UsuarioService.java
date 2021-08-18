package br.com.projeto.service;

import br.com.projeto.model.Usuario;

public interface UsuarioService {

	public Usuario pesquisarUsuarioPorLoginSenha(String perfil, String login, String senha);

}
