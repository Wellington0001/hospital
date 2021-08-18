package br.com.projeto.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public Usuario pesquisarUsuarioPorLoginSenha(String perfil, String login, String senha) {
		return (Usuario) sessionFactory.getCurrentSession().createQuery(
				"from Usuario as usuario where usuario.login =:login and usuario.senha =:senha and usuario.class=:perfil")
				.setString("login", login).setString("senha", senha).setString("perfil", perfil).uniqueResult();
	}

}
