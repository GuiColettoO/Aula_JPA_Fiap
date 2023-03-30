package br.com.fiap.jpa.exception;

import br.com.fiap.jpa.dao.EntidadeNaoEncontradaException;

public class CommitException extends Exception{
	
	public CommitException() {
		super("Erro ao realizar o commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
	
}
