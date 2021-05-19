package main;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import BO.Gravacao;
import BO.Persistencia;
import DAO.GravarCSV;
import DAO.GravarJSON;
import DAO.GravarXML;
import DTO.Aluno;
import DTO.ListaAlunos;
import DTO.Pessoa;

import DAO.GravarBD;

import java.time.LocalDate;



public class main {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		GravarCSV csv = new GravarCSV();
		GravarJSON json = new GravarJSON();
		GravarXML xml = new GravarXML();

		Persistencia pers = new Persistencia(csv);
		Persistencia pers2 = new Persistencia(xml);
		Persistencia pers3 = new Persistencia(json);
		

		Aluno aluno = new Aluno();
		
		aluno.setNome("Jefferson");
		aluno.setMatricula("70854517");
		aluno.setCpf("123.456.789-11");
		aluno.setDataNasc(ListaAlunos.retornaData("12/01/2000"));
		aluno.setEmail("email@email.com");
		
		Gravacao gravar = new GravarBD();
		Persistencia pers4 = new Persistencia(gravar);
		
		alunos.add(aluno);
		
		pers.gravar(alunos);
		pers2.gravar(alunos);
		pers3.gravar(alunos);
		pers4.gravar(alunos);
		

	}

}
