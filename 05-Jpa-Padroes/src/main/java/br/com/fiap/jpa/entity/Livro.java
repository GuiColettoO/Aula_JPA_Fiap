package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_LIVRO")
@SequenceGenerator(sequenceName = "SQ_T_LIVRO", name="taldo", allocationSize = 1)
public class Livro {
	
	@Id
	@Column(name = "cd_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taldo")
	private int id;
	
	@Column(name="ds_titulo", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nr_pagina", length = 4)
	private String pagina;
	
	@Column(name="dt_lancamento")
	private Calendar datalancamento;

	public int getId() {
		return id;
	}
	
	public Livro() {};

	public Livro(int id, String nome, String pagina, Calendar datalancamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.pagina = pagina;
		this.datalancamento = datalancamento;
	}
	
	@PrePersist //Antes de cadastrar
	@PostUpdate //Ap�s atualizar
	@PostLoad //Executa apos um select
	private void executar() {
		System.out.println("Executando um comando SQL");
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public Calendar getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Calendar datalancamento) {
		this.datalancamento = datalancamento;
	}
}
