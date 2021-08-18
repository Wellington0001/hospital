package br.com.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;
import br.com.projeto.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario pesquisarUsuarioPorLoginSenha(String perfil, String login, String senha) {
		return usuarioDAO.pesquisarUsuarioPorLoginSenha(perfil, login, senha);
	}

}
