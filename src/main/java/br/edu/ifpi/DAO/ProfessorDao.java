package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

    public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Professor professor) {
        String SQL_INSERT = "INSERT INTO PROFESSOR (NOME, EMAIL) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(SQL_INSERT);

            preparedStatement.setString(1, professor.getNome());
            preparedStatement.setString(2, professor.getEmail());

            int row = preparedStatement.executeUpdate();

            System.out.println(row);
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    @Override
    public List<Professor>consultarTodos(){
        return null;
    }
    @Override
    public int alterar(Professor professor){
        try {
            String modificacao = "UPDATE professor SET NOME=?, EMAIL=? WHERE ID=?" + professor.getId();
            PreparedStatement stmt = conexao.prepareStatement(modificacao);
            stmt.setString(1,professor.getNome());
            stmt.setString(2,professor.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int remover(Professor professor){
         String remocacao = "DELETE FROM PROFESSOR (NOME,EMAIL)";
        try {
           
            PreparedStatement stmt = conexao.prepareStatement(remocacao);
            stmt.setInt(1, (int) professor.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return 0;
    }
}
