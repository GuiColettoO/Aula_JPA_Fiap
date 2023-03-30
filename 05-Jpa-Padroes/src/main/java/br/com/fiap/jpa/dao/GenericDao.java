package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEncontradaException;

public interface GenericDao<E, K> {
	
	void salvar(E entidade);
	void deletar(K id) throws EntidadeNaoEncontradaException;
	E buscar(K id) throws EntidadeNaoEncontradaException;
	void commit() throws CommitException;
}
