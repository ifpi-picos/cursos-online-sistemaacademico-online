package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.enums.StatusCurso;

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
                aluno.setId_aluno(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                al.add(aluno);

            }
            for (Aluno a : al) {
                System.out.println(
                        "id " + a.getId_aluno() + "\t Nome: " + a.getNome() + "\t Email: " + a.getEmail());
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
        String sqlUpdate = "UPDATE aluno SET NOME=?, EMAIL=? WHERE ID=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlUpdate);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getId_aluno());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remover(Aluno aluno) {
        String sqlDelete = "DELETE FROM aluno WHERE ID = ?";

        try {

            PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
            stmt.setInt(1, aluno.getId_aluno());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover o professor: " + e.getMessage());
        }
        return 0;
    }

    public void visualizar() {
        String selecaoColuna = "SELECT id, nome FROM aluno where email= ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(selecaoColuna);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Nome do Aluno: " + rs.getString("nome_aluno") + "\tNome Curso: "
                        + rs.getString("nome_curso"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> exibirCursosMatriculados(int id_al) {
        ResultSet rs = null;
        List<Curso> cursosMatriculados = new ArrayList<>();
        String sqlMatriculados = "SELECT aluno.nome , curso.nome as name " +
                "FROM aluno " +
                "JOIN curso_aluno ON aluno.id = curso_aluno.id_aluno " +
                "JOIN curso ON curso_aluno.id_curso = curso.id " +
                "WHERE aluno.id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlMatriculados);
            stmt.setInt(1, id_al);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("nome"));
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursosMatriculados;
    }

    public void criarAproveitamentoCurso(){
        String sqlClausa = "UPDATE curso_aluno SET aproveitamento = nota * 10.0 WHERE id_aluno > 0 ";
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
    public void mostrarAproveitamento() {
        String select = "SELECT aluno.nome AS nome_aluno, curso.nome AS nome_curso, curso_aluno.aproveitamento " +
                        "FROM curso_aluno " +
                        "JOIN aluno ON curso_aluno.id_aluno = aluno.id " +
                        "JOIN curso ON curso_aluno.id_curso = curso.id " +
                        "WHERE aluno.id > 0";
        try {
            PreparedStatement stmt = conexao.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            System.out.printf("%-30s | %-30s | %-15s\n", "Nome do Aluno", "Nome do Curso", "Aproveitamento");
            while (rs.next()) {
                System.out.printf("%-30s | %-30s | %-15s\n", rs.getString("nome_aluno"), rs.getString("nome_curso"), rs.getString("aproveitamento"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deu um erro!");
        }
    }
    


}
