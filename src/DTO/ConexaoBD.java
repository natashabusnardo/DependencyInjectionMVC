package DTO;

import java.sql.Connection;

public interface ConexaoBD {
	abstract Connection abreConexao();
	abstract boolean verificaConexao();
	abstract boolean fechaConexao();
}
