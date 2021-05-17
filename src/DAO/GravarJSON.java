package DAO;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DTO.Aluno;
import DTO.Gravacao;
import DTO.ListaAlunos;

public class GravarJSON implements Gravacao {

	public List<Aluno> ler() throws ParseException {
		List<Aluno> lista = new ArrayList<Aluno>();
		Aluno a = new Aluno();
		try {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			BufferedReader bufferedReader = new BufferedReader(new FileReader("alunos.json"));
			String linha = bufferedReader.readLine();
			lista = new ArrayList<Aluno>();
			while (linha != null) {
				String[] leitura = linha.split(";");
				a = new Aluno();
				a.setNome(leitura[0]);
				a.setMatricula(leitura[1]);
				a.setCpf(leitura[2]);
				a.setDataNasc(ListaAlunos.retornaData(leitura[3]));
				a.setEmail(leitura[4]);
				lista.add(a);
				linha = bufferedReader.readLine();
			}
			bufferedReader.close();
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean gravar(List<Aluno> list) {
		ListaAlunos lista = new ListaAlunos();
		lista.setLista(list);
		try {
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.create();

			FileWriter writer = new FileWriter("alunos.json", true);

			writer.write(gson.toJson(lista, ListaAlunos.class));

			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
}