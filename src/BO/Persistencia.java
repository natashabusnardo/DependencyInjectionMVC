package BO;

import java.text.ParseException;
import java.util.List;

import DTO.Aluno;
import DTO.Gravacao;

public class Persistencia {
	
	private Gravacao g;
	
	public Persistencia(Gravacao g) {
		this.g = g;
	}
	
	public boolean gravar(List<Aluno> list) {
		return g.gravar(list);
		
	}
	public List<Aluno> ler() throws ParseException{
		return g.ler();
	}

	
}