package com.intelifis.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.intelifis.api.model.Mapa;
import com.intelifis.api.model.Plano;

public class ExtraiPlano {

	private List<Plano> lista = new ArrayList<>();
	private int iConta; 
	private int iTipo; 
	private int iIndcta;
	private int iNivel;
	private int iDescricao;
	

	public void adiciona(Plano pln) {
		this.lista.add(pln);
	}
	
	

	public List<Plano> extrai(BufferedReader br) {
		
		getIndices();

		ArrayList<String> conta = new ArrayList<>();
		String refer = "";
		String aglut = "";

		try {
			while (br.ready()) {
				String linha = br.readLine();

				if (linha.contains("|I050|")) {
					conta.add(linha);
				}
				
				if (linha.contains("|I051||")) {
					String str[] = linha.split("\\|");
					refer = str[3];

					br.mark(20);
					linha = br.readLine();
					if (linha.contains("|I052||")) {						
						criaObj(conta, refer, aglut);
						conta.clear();						
					} else {
						br.reset();
						criaObj(conta, refer, aglut);
						conta.clear();					
					}										
				}	
				
				if (linha.contains("|I052||")) {
					String str2[] = linha.split("\\|");
					aglut = str2[3];
					
					criaObj(conta, refer, aglut);
					conta.clear();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;

	}

	
	
	public void criaObj(ArrayList<String> pln, String plnRef, String aglut) {
		for (String x : pln) {

			String str[] = x.split("\\|");
			
			if (!(str.length < 8)){
			String conta = str[iConta];
			String tipo = str[iTipo];
			String indcta = str[iIndcta];
			String nivel = str[iNivel];
			String descricao = str[iDescricao];
			String contaref = plnRef;
			String codaglut = aglut;

			this.adiciona(new Plano(conta, descricao, tipo, indcta, nivel, contaref, codaglut));
			}
		}
	}
	
	
	
	public void getIndices() {
		this.iConta = Mapa.getProperty("I050.conta");
		this.iTipo = Mapa.getProperty("I050.tipo");
		this.iIndcta = Mapa.getProperty("I050.indcta");
		this.iNivel = Mapa.getProperty("I050.nivel");
		this.iDescricao = Mapa.getProperty("I050.descricao");
	}

}