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

    public AlunoDao(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        String SQL_INSERT = "INSERT INTO ALUNOS (NOME, EMAIL) VALUES(?,?)";

        try{
            PreparedStatement stmt =  conexao.prepareStatement(SQL_INSERT);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
        }catch (SQLException e){
            System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Aluno> consultarTodos() {
       ResultSet rs = null;
       try {
        String consulta = "SELECT * FROM alunos ORDER BY id";
        PreparedStatement pstm = conexao.prepareStatement(consulta);
        rs = pstm.executeQuery();

        while (rs.next()) {
        
        }
       } catch (Exception e) {
        e.printStackTrace();
       }
    return null;
}

    @Override
    public int alterar(Aluno aluno) {
        try {
            String sqlUpdate = "UPDATE alunos SET NOME=?, EMAIL=? WHERE ID=?" + aluno.getId();
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
        try {
            String sqlDelete = "DELETE FROM alunos WHERE ID=?" + aluno.getId();
            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, (int) aluno.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
