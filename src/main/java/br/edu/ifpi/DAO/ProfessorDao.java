package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

    public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    }

    // -------------------------------------CADASTRO--------------------------------------------------------
    @Override
    public int cadastrar(Professor professor) {
        String SQL_INSERT = "INSERT INTO professor (nome, email) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(SQL_INSERT);

            preparedStatement.setString(1, professor.getNomeP());
            preparedStatement.setString(2, professor.getEmail());

            int row = preparedStatement.executeUpdate();

            System.out.println(row);
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // ----------------------------------------------------CONSULTA------------------------------------------
    @Override
    public List<Professor> consultarTodos() {

        List<Professor> professores = new ArrayList<>();
        String consulta = "SELECT * FROM PROFESSOR ORDER BY id ";

        try {
            PreparedStatement statement = conexao.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Professor prof = new Professor();
                prof.setId(resultSet.getInt("id"));
                prof.setNomeP(resultSet.getString("nome"));
                prof.setEmail(resultSet.getString("email"));

                professores.add(prof);

            }
            for (Professor p : professores) {
                System.out.println("id : " + p.getId() + "\t Nome  :" + p.getNomeP() + "\t" + p.getEmail());
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar professores", e);
        }
        return professores;
    }
    // ------------------------------------------------VIZUALIZAR--------------------------------------------------------

    public void visualizarProfessor() {
        String selecaoColuna = "SELECT curso.nome AS nome_curso, professor.nome AS nome_professor FROM curso INNER JOIN professor ON curso.id_professor = professor.id";
        try {
            PreparedStatement stmt = conexao.prepareStatement(selecaoColuna);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Nome do Professor: " + rs.getString("nome_professor") + "\tNome Curso: "
                        + rs.getString("nome_curso"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -----------------------------------------ALTERAR------------------------------------------
    @Override
    public int alterar(Professor professor) {

        String modificacao = "UPDATE professor SET NOME=?, EMAIL=? WHERE ID=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(modificacao);

            stmt.setString(1, professor.getNomeP());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, professor.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
//-------------------------------------------------------REMOVER -----------------------------------

    @Override
    public int remover(Professor professor) {

        String remocao = "DELETE FROM professor WHERE id = ?";
        try  {
            PreparedStatement stmt = conexao.prepareStatement(remocao);
            stmt.setInt(1, professor.getId());

         stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover o professor: " + e.getMessage());
        }
        return 0;
    }

    public int cadastrarCurso(Curso curso) {
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

}
