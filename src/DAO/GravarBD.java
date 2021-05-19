package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BO.Conexao;
import BO.Gravacao;
import DTO.Aluno;
import DTO.ListaAlunos;


public class GravarBD implements Gravacao {

    private final String NOMEDATABELA = "aluno";

    @Override
    public boolean gravar(List<Aluno> alunos) {

        for (Aluno aluno : alunos) {

            try {
                Connection conn = Conexao.conectar();
                String sql = "INSERT INTO " + NOMEDATABELA
                        + " (cpf,email,matricula,nome,data_nasc) VALUES (?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, aluno.getCpf());
                ps.setString(2, aluno.getEmail());
                ps.setString(3, aluno.getMatricula());
                ps.setString(4, aluno.getNome());
                ps.setString(5, ListaAlunos.DataForStringMySQL(aluno.getDataNasc()));
                ps.executeUpdate();
                ps.close();
                conn.close();
                return true;
            } catch (Exception e) {
                System.err.println("Erro: " + e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Aluno> ler() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return null;
        }
    }

    public List<Aluno> montarLista(ResultSet rs) {
        List<Aluno> listObj = new ArrayList<Aluno>();
        try {
            while (rs.next()) {
                Aluno obj = new Aluno();
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setMatricula(rs.getString("matricula"));
                obj.setDataNasc(ListaAlunos.DataMySQLHoraDia(rs.getString("dataNascimento")));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

}