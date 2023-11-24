package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.entidades.Turma;

public class TurmaDao implements Dao<Turma>{
    private Connection conexao;
    
    public TurmaDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public int cadastrar(Turma turma) {
        String addturma = "INSERT INTO turma (id_curso, id_aluno, nota) VALUES(?,?,?)";
        try {
            PreparedStatement psmt = conexao.prepareStatement(addturma);
            psmt.setInt(1, turma.getId_curso());
            psmt.setInt(2, turma.getId_aluno());
            psmt.setDouble(3, turma.getNota());
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Turma> consultarTodos() {
        List<Turma> turmas = new ArrayList<>();
        String sqlSelect = "SELECT * FROM turma";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Turma turma = new Turma();
                turma.setId_curso(rs.getInt("id_curso"));
                turma.setId_aluno(rs.getInt("id_aluno"));
                turma.setNota(rs.getDouble("nota"));
                turmas.add(turma);
            }

            for (Turma t : turmas){
                System.out.println("id_aluna : " + t.getId_aluno() + "\t Nota: " + t.getNota() + "\t id_curso :" + t.getId_curso());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return turmas;
    }

    @Override
    public int alterar(Turma turma) {
        String sqlUpdate = "UPDATE turma SET id_curso=?, id_aluno=?, nota=? WHERE ID=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
            stmt.setInt(1, turma.getId_curso());
            stmt.setInt(2, turma.getId_aluno());
            stmt.setDouble(3, turma.getNota());
            stmt.executeUpdate();

            System.out.println(turma.getId_curso()+" aluno " + turma.getId_aluno() + " nota" + turma.getNota());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int remover(Turma turma) {
        String sqlDelete = "DELETE FROM turma WHERE Id_aluno = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, turma.getId_aluno());
            stmt.executeUpdate();
            System.out.println(turma.getId_aluno()  + " curso removido");
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, "Erro ao tentar remover Curso :( " + e.getMessage());
        }
        return 0;
    }

    public void gerarEstaticas(){
        String sqlSituacao = "UPDATE turma SET situacao = CASE WHEN nota >= 6.0 THEN 'Aprovado' ELSE 'Reprovado' END ";
        try {
            PreparedStatement psmt = conexao.prepareStatement(sqlSituacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
