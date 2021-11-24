package com.intelifis.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Plano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String conta;
	private String descricao;
	private String tipo;
	private String indcta;
	private String nivel;
	private String contaref;
	private String aglut;
	


	public Plano(String conta, String descricao, String tipo, String indcta, String nivel, String contaref, String aglut) {
		this.conta 		= conta;
		this.descricao 	= descricao;
		this.tipo 		= tipo;
		this.indcta 	= indcta;
		this.nivel		= nivel;
		this.contaref 	= contaref;
		this.aglut		= aglut;
	}

	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getIndcta() {
		return indcta;
	}
	public void setIndcta(String indcta) {
		this.indcta = indcta;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getContaref() {
		return contaref;
	}
	public void setContaref(String contaref) {
		this.contaref = contaref;
	}
	public String getAglut() {
		return aglut;
	}
	public void setAglut(String aglut) {
		this.aglut = aglut;
	}


}
