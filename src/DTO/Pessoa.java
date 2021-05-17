package DTO;

public class Pessoa {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length() > 0)
			this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
}
