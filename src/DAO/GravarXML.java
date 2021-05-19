package DAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import BO.Gravacao;
import DTO.Aluno;

public class GravarXML implements Gravacao {

	public List<Aluno> ler() throws ParseException {
		try {
			List<Aluno> lista = new ArrayList<Aluno>();
			FileInputStream fis = new FileInputStream("alunos.xml");
			BufferedInputStream buff = new BufferedInputStream(fis);
			XMLDecoder xml = new XMLDecoder(buff);
			lista = (List<Aluno>) xml.readObject();
			xml.close();
			return lista;
		} catch (IOException e) {
			System.err.printf("Erro na Abertura do Arquivo: %s. \n", e.getMessage());
			return null;
		}
	}

	public boolean gravar(List<Aluno> lista) {
		try {
			FileWriter writer = new FileWriter("persistencia.xml");

			String dadosAluno = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";

			for (Aluno aluno : lista) {
				dadosAluno += "<aluno>\n";
				dadosAluno += "<nome>" + aluno.getNome() + "</nome>";
				dadosAluno += "<matricula>" + aluno.getMatricula() + "</matricula>";
				dadosAluno += "<CPF>" + aluno.getCpf() + "</CPF>";
				dadosAluno += "<email>" + aluno.getEmail() + "</email>";
				dadosAluno += "<dataNascimento>" + aluno.getDataNasc().toString() + "</dataNascimento>";
				dadosAluno += "</aluno>\n";
			}

			writer.write(dadosAluno);

			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}