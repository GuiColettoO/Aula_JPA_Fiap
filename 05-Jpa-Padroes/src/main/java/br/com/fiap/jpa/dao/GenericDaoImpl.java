package br.com.fiap.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEncontradaException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {

	private Class<E> C;
	
	private EntityManager em;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		//Obter o .class de E em tempo de execução
		this.C = (Class<E>) ((ParameterizedType) 
				getClass().getGenericSuperclass()).
				getActualTypeArguments()[0];
	}
	
	public void salvar(E entidade) {
		em.merge(entidade);
		
	}

	public void deletar(K id) throws EntidadeNaoEncontradaException {
		E pessoa = buscar(id);
		em.remove(pessoa);
		
	}

	public E buscar(K id) throws EntidadeNaoEncontradaException {
		E pessoa = em.find(C, id);
		// Verificar se o usuario existe 
		if (pessoa == null)
			throw new EntidadeNaoEncontradaException("Usuario não encontrado");
		return pessoa;
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			// Exibe o "log" do problema ocorrido
			e.printStackTrace();
			em.getTransaction().rollback();
			// Lançar uma exception
			throw new CommitException();
		}
		
	}

}
