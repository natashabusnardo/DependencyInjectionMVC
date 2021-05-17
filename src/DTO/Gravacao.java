package DTO;

import java.text.ParseException;
import java.util.List;

public interface Gravacao {
	
	
	public boolean gravar(List<Aluno> list);

	public List<Aluno> ler() throws ParseException;

}