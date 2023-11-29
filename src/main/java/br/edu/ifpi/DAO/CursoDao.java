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
import br.edu.ifpi.enums.StatusCurso;

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
            stmt.setString(1, curso.getNomeC());
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
                curso.setStatus(StatusCurso.valueOf(rs.getString("status")));
                curso.setCargahoraria(rs.getInt("cargahoraria"));
                curso.setProf_id(rs.getInt("id_professor"));
                cursos.add(curso);
            }

            for (Curso c : cursos){
                System.out.println("id : " + c.getId() + "\t Nome: " + c.getNomeC() + "\t carga horaria :" + c.getCargahoraria() + "\t" + c.getStatus());
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
            String sqlUpdate = "UPDATE curso SET nome=?, status=?, cargahoraria=?, id_professor=? WHERE ID=?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
                stmt.setString(1, curso.getNomeC());
                stmt.setString(2, curso.getStatus().name());
                stmt.setInt(3, curso.getCargahoraria());
                stmt.setInt(4, curso.getProf_id());
                stmt.setInt(5, curso.getId());
                stmt.executeUpdate();
    
                System.out.println(curso.getId() +" " + curso.getNomeC() + " " + curso.getCargahoraria() + " "+ curso.getProf_id() + " " + curso.getStatus());
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
    public int calcularMediaGeral(int id_curso){
        String sqlAVG = "UPDATE curso SET media_geral = (SELECT AVG(nota) AS media_g FROM curso_aluno WHERE id_curso = ?) WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlAVG);
            stmt.setInt(1, id_curso);
            stmt.setInt(2, id_curso);
            int update = stmt.executeUpdate();
            if (update > 0){ 
                System.out.println("Média atualizada com sucesso");
        } }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi possivel calcular a media");
        }
        return 0;
    }
    public void exibirAproveitamentoCurso(){
        String sqlClausa = "UPDATE curso SET aproveitamento = (SELECT TO_CHAR(SUM(CASE WHEN situacao = 'Aprovado' THEN 1 ELSE 0 END) * 100.0 / COUNT(*), 'FM9999.99') || '%' " +
                "FROM curso_aluno WHERE id_curso = curso.id)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlClausa);
            int update = stmt.executeUpdate();
            if (update > 0){
                System.out.println("Aproveitamento realizado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi possível realizar o aproveitamento do curso.");
        }
    }
    
}