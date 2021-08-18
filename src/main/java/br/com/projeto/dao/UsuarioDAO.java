package br.com.projeto.dao;

import br.com.projeto.model.Usuario;

public interface UsuarioDAO {

	public Usuario pesquisarUsuarioPorLoginSenha(String perfil, String login, String senha);

}
