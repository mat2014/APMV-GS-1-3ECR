package main;

import java.util.ArrayList;

public class GerenciarPostos {
	
	private ArrayList<Posto> postosCadastrados = new ArrayList<Posto>();

	public ArrayList<Posto> getPostosCadastrados() {
		return postosCadastrados;
	}
	
	public void cadastrarPosto(Posto postoNovo) {
		if (postoNovo != null) {
			postosCadastrados.add(postoNovo);			
		}
	}
}
