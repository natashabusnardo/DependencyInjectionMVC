package DTO;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Aluno extends Pessoa {
	private String matricula;
	private String cpf;
	private Date dataNasc;
	private String email;


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() > 0)
			this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", CPF=");
		builder.append(cpf);
		builder.append(", dataNasc=");
		builder.append(dataNasc);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

}
