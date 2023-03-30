package br.com.fiap.jpa.exception;

public class EntidadeNaoEncontradaException extends Exception{
	
	public EntidadeNaoEncontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
}
