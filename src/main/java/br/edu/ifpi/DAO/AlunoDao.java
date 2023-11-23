package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.entidades.Aluno;

public class AlunoDao implements Dao<Aluno> {
    private Connection conexao;

    public AlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        String SQL_INSERT = "INSERT INTO ALUNO (NOME, EMAIL) VALUES(?,?)";

        try {

            PreparedStatement stmt = conexao.prepareStatement(SQL_INSERT);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            int row = stmt.executeUpdate();

            System.out.println(row);
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Aluno> consultarTodos() {
        ResultSet rs = null;
        List<Aluno> al = new ArrayList<>();
        String consulta = "SELECT * FROM aluno ORDER BY id";
        try {
            PreparedStatement pstm = conexao.prepareStatement(consulta);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_aluno(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                al.add(aluno);

            }
            for (Aluno aluno : al) {
                System.out.println(
                        "id" + aluno.getId_aluno() + "\t Nome: " + aluno.getNome() + "\t Email: " + aluno.getEmail());
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int alterar(Aluno aluno) {
        String sqlUpdate = "UPDATE alunos SET NOME=?, EMAIL=? WHERE ID=?" + aluno.getId_aluno();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remover(Aluno aluno) {
        String sqlDelete = "DELETE FROM alunos WHERE ID = ?" + aluno.getId_aluno();

        try {

            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, (int) aluno.getId_aluno());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
