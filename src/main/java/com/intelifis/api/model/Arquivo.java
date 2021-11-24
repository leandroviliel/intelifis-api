package com.intelifis.api.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.intelifis.api.controller.ExtraiPlano;
import com.intelifis.api.controller.ExtraiBalanco;

public class Arquivo {
	private String caminho;
	private String conteudo;
	public List<Plano> pln;
	public List<Balanco> bal;

	


	public void lerObj(String caminho, String tipo) {

		
		File arquivo = new File(caminho);
		FileReader fr = null;
		
		try {
			fr = new FileReader(arquivo);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(fr);
		
			if (tipo == "plano") {				
				this.setPln( new ExtraiPlano().extrai(br) );
			}
	
			if (tipo == "balanco") {
				this.setBal( new ExtraiBalanco().extrai(br) );
			}

		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	


	}

	
	
	

	
	
	

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void setPln(List<Plano> pln) {
		this.pln = pln;
	}

	public void setBal(List<Balanco> bal) {
		this.bal = bal;
	}
	
	public List<Plano> getPln() {
		return pln;
	}

	
	public List<Balanco> getBal() {
		return bal;
	}
}
