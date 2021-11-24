package com.intelifis.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Balanco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String aglut;
	private String tipo;
	private String nivel;
	private String grupo;
	private String descricao;
	private String valor;
	private String indcta;


	public Balanco(String aglut, String tipo, String nivel, String grupo, String descricao, String valor,
			String indcta) {		
		this.aglut = aglut;
		this.tipo = tipo;
		this.nivel = nivel;
		this.grupo = grupo;
		this.descricao = descricao;
		this.valor = valor;
		this.indcta = indcta;
	}

	public String getAglut() {
		return aglut;
	}

	public void setAglut(String aglut) {
		this.aglut = aglut;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIndcta() {
		return indcta;
	}

	public void setIndcta(String indcta) {
		this.indcta = indcta;
	}

	

}
