package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.UsuarioDaoImpl;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

public class TesteDao {
	
	//Verificar se os metodos do DAO estao funcionando
	public static void main(String[] args) throws EntidadeNaoEncontradaException {
		
		Usuario user = new Usuario("Renato Augusto", "123", 
				"45654654646", "renato@timao.com", 1.8f, TipoUsuario.DEFAULT);
		//Criar uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Criar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		//Instanciar um DAO
		UsuarioDao usuario = new UsuarioDaoImpl(em);
		//Cadastrar um usuario
		usuario.cadastrar(user);
		//Pesquisar um usuario
		usuario.pesquisar(2);
		//Atualizar um usuario
		user.setNome("Joao");
		usuario.atualizar(user);
		//Remover um usuario
		usuario.deletar(2);

	}

}
