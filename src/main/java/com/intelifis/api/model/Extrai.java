package com.intelifis.api.model;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public interface Extrai {

	void adiciona(Balanco b);

	List<Balanco> extrai(BufferedReader br);

	void criaObj(ArrayList<String> pln);

	void getIndices();

}
