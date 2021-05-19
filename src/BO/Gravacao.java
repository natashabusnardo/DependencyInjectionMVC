package BO;

import java.text.ParseException;
import java.util.List;

import DTO.Aluno;

public interface Gravacao {
	
	
	public boolean gravar(List<Aluno> list);

	public List<Aluno> ler() throws ParseException;


}