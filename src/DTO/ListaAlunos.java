package DTO;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaAlunos {
	List<Aluno> lista = new ArrayList<Aluno>();

	public List<Aluno> getLista() {
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public void inserir(Aluno a) throws IOException {
		lista.add(a);
	}

	/*
	 * public void excluir(int cod) throws IOException { for (Aluno Contato : lista)
	 * { if (Contato.getCodigo() == cod) { lista.remove(Contato); } } }
	 */

	/*
	 * public void alterar(Pedido p, int cod) throws IOException { for (Pedido
	 * Contato : lista) { if (p.equals(Contato)) { p.setCodigo(p.getCodigo());
	 * p.setData(p.getData()); p.setFormaPagamento(p.getFormaPagamento());
	 * p.setTipoEntrega(p.getFormaPagamento());
	 * p.setStatusPedido(p.getStatusPedido()); } } }
	 */

	public static String retornaData(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataString = format.format(data);
		return dataString;
	}

	public static Date retornaData(String data) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDate = format.parse(data);
		return dataDate;
	}

	public static String DataForStringMySQL(Date pDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = "";
		try {
			s = df.format(pDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	public static Date DataMySQLHoraDia(String pDate) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");

		Date dia = null;
		try {

			dia = df.parse(pDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaAluno [lista=");
		builder.append(lista);
		builder.append("]");
		return builder.toString();
	}
}
