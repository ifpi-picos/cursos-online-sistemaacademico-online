package br.edu.ifpi.DAO;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Curso;

public class CursoDao implements Dao<Curso>{
    private Connection conexao;
    
    public CursoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Curso curso) {
          String SQL_INSERT = "INSERT INTO Curso (NOME, STATUS, CARGAHORARIA, PROF_ID) VALUES(?,?,?,?)";

        try{
            PreparedStatement stmt =  conexao.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getStatus().name());
            stmt.setInt(3, curso.getCargahoraria());
            stmt.setInt(4, curso.getProf_id());
        }catch (SQLException e){
            System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;  
      }

    @Override
    public List<Curso> consultarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM Curso";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Curso curso = new Curso();
                curso.setId(rs.getInt("CURSO_ID"));
                curso.setNome(rs.getString("NOME"));
                curso.setStatus(Enum.valueOf(Status.class, rs.getString("STATUS")));
                curso.setCargahoraria(rs.getInt("CARGAHORARIA"));
                curso.setProf_id(rs.getInt("PROF_ID"));
                cursos.add(curso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public int alterar(Curso curso) {
        String sqlUpdate = "UPDATE cursos SET NOME=?, STATUS=?, CARGAHORARIA=? PROF_ID=? WHERE ID=?" + curso.getId();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getStatus().name());
            stmt.setInt(3, curso.getCargahoraria());
            stmt.setInt(4, curso.getProf_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void visualizarCursos() {
        String selecaoColuna = "SELECT ID, NOME FROM CURSO";
        try {
            PreparedStatement stmt = conexao.prepareStatement(selecaoColuna);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" + rs.getString("NOME"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int remover(Curso curso) {
        visualizarCursos();
        String sqlDelete = "DELETE FROM CURSO WHERE ID = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, curso.getId());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover Curso :( " + e.getMessage());
        }
        return 0;
    }
    
}