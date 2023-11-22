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
          String SQL_INSERT = "INSERT INTO curso (nome, status, cargahoraria, id_professor) VALUES(?,?,?,?)";

        try{
            PreparedStatement stmt =  conexao.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNome());
            stmt.setInt(3, curso.getCargahoraria());
            stmt.setInt(4, curso.getProf_id());
            stmt.setString(2, curso.getStatus().name());
            int row = stmt.executeUpdate();

            System.out.println(row);
            return row;
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
        String sqlSelect = "SELECT * FROM curso";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                // curso.setStatus(Enum.valueOf(Status.class, rs.getString("status")));
                curso.setCargahoraria(rs.getInt("cargahoraria"));
                curso.setProf_id(rs.getInt("id_professor"));
                cursos.add(curso);
            }

            for (Curso c : cursos){
                System.out.println("id : " + c.getId() + "\t Nome: " + c.getNome() + "\t carga horaria :" + c.getCargahoraria());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }

        public void visualizarCursos() {
            String selecaoColuna = "SELECT ID, NOME, cargahoraria FROM CURSO";
            try {
                PreparedStatement stmt = conexao.prepareStatement(selecaoColuna);
                ResultSet rs = stmt.executeQuery();
                System.out.println("-----------Cursos-----------");
                while (rs.next()) {
                    System.out.println(rs.getInt("ID") + "\t" + rs.getString("NOME"));
                }             
                System.out.println("-----------------------------");
    
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    @Override
    public int alterar(Curso curso) {
        String sqlUpdate = "UPDATE curso SET nome=?, status=?, cargahoraria=? id_professor=? WHERE ID=?" + curso.getId();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getStatus().name());
            stmt.setInt(3, curso.getCargahoraria());
            stmt.setInt(4, curso.getProf_id());

            System.out.println(curso.getId() +" " + curso.getNome() + " " + curso.getCargahoraria() + " "+ curso.getProf_id() + " " + curso.getStatus().name());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int remover(Curso curso) {
        String sqlDelete = "DELETE FROM CURSO WHERE ID = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, curso.getId());
            stmt.executeUpdate();
            System.out.println(curso.getId()  + " curso removido");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover Curso :( " + e.getMessage());
        }
        return 0;
    }
    
}