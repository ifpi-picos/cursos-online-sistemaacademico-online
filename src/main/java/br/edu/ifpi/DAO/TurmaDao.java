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
                turma.add(turmas);
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
    public int alterar(Turma entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
    
    @Override
    public int remover(Turma entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    public void gerarEstaticas(){
        String sqlSituacao = "UPDATE aluno SET situacao = CASE WHEN nota >= 6.0 THEN 'Aprovado' ELSE 'Reprovado' END ";
        try {
            PreparedStatement psmt = conexao.prepareStatement(sqlSituacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
