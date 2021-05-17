package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import DTO.Aluno;
import DTO.Gravacao;
import DTO.ListaAlunos;

public class GravarCSV implements Gravacao {

	public List<Aluno> ler() throws ParseException {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			Aluno a = new Aluno();
			FileReader arq1 = new FileReader("alunos.csv");
			BufferedReader lerArq = new BufferedReader(arq1);
			String linha = lerArq.readLine();

			while (linha != null) {
				String[] leitura = linha.split(",");
				a = new Aluno();
				a.setNome(leitura[0]);
				a.setMatricula(leitura[1]);
				a.setCpf(leitura[2]);
				a.setDataNasc(ListaAlunos.retornaData(leitura[3]));
				a.setEmail(leitura[4]);
				;
				lista.add(a);
				linha = lerArq.readLine();
			}

			arq1.close();
			return lista;
		} catch (IOException e) {
			System.err.printf("Erro na Abertura do Arquivo: %s. \n", e.getMessage());
			return null;
		}
	}

	public boolean gravar(List<Aluno> lista) {
		try {
			FileWriter arq = new FileWriter("alunos.csv", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			for (Aluno aluno : lista) {
				gravarArq.printf("%s,%s,%s,%s,%s\n", aluno.getNome(), aluno.getMatricula(), aluno.getCpf(), ListaAlunos.retornaData(aluno.getDataNasc()), 
														   aluno.getEmail());
			}
			
			arq.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}