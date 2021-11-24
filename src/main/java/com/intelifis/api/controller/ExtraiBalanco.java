package com.intelifis.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.intelifis.api.model.Mapa;
import com.intelifis.api.model.Balanco;
import com.intelifis.api.model.Extrai;

public class ExtraiBalanco implements Extrai{

	private List<Balanco> lista = new ArrayList<>();
	
	private int iAglut	;
	private int iTipo 	;
	private int iNivel 	;
	private int iGrupo 	;
	private int iDescricao ;
	private int iValor 	;
	private int iIndcta	;
	

	
	@Override
	public void adiciona(Balanco pln) {
		this.lista.add(pln);
	}


	public List<Balanco> extrai(BufferedReader br) {
		
		getIndices();

		ArrayList<String> bal = new ArrayList<>();

		try {
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("|J100|")) {
					System.out.println(linha);
					bal.add(linha);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (bal.size() > 0) {
			criaObj(bal);
		}
		
		return lista;

	}


	@Override
	public void criaObj(ArrayList<String> pln) {
		for (String x : pln) {

			String str[] = x.split("\\|");
			
			if (!(str.length < 8)){
				
			String aglut	= str[iAglut];
			String tipo		= str[iTipo];
			String nivel	= str[iNivel];
			String grupo	= str[iGrupo];
			String descricao= str[iDescricao];
			String valor	= str[iValor];
			String indcta	= str[iIndcta];							

			this.adiciona(new Balanco(aglut, tipo, nivel, grupo, descricao, valor, indcta));
			}
		}
	}
	
	
	@Override	
	public void getIndices() {
		this.iAglut		= Mapa.getProperty("J100.aglut");
		this.iTipo 		= Mapa.getProperty("J100.tipo");
		this.iNivel 	= Mapa.getProperty("J100.nivel");
		this.iGrupo 	= Mapa.getProperty("J100.grupo");
		this.iDescricao = Mapa.getProperty("J100.descricao");
		this.iValor 	= Mapa.getProperty("J100.valor");
		this.iIndcta	= Mapa.getProperty("J100.indcta");
	}


	



}