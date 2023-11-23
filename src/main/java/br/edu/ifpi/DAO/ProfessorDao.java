package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

    public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    }

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
        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    @Override
    public List<Professor>consultarTodos(){
            List<Professor> professores = new ArrayList<>(); 
    
            String consulta = "SELECT * FROM PROFESSOR";
    
            try (PreparedStatement statement = conexao.prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                Professor professor = new Professor(id,nome, email);

                
                professores.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar professores", e);
        }
    
            return professores;
        }
        public void visualizarProfessor() {
            String selecaoColuna = "SELECT nome , nome FROM professor INNER JOIN curso ON professor.nome = curso.nome";
            try {
                PreparedStatement stmt = conexao.prepareStatement(selecaoColuna);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("NOME") + "\t" + rs.getString("NOME"));
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
   // @Override
    // public int alterar(Professor professor){
    //     try {
    //         String modificacao = "UPDATE professor SET NOME=?, EMAIL=? WHERE ID=?" + professor.getId();
    //         PreparedStatement stmt = conexao.prepareStatement(modificacao);
    //         stmt.setString(1,professor.getNome());
    //         stmt.setString(2,professor.getEmail());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return 0;
    // }
    @Override
    public int remover(Professor professor){
        
        String remocao="DELETE FROM professsor WHERE id = ?" ;
        try(PreparedStatement stmt = conexao.prepareStatement(remocao)) {
        stmt.setInt(1, professor.getId());
        return stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao tentar remover o professor: " + e.getMessage());
    }
    return 0;
}

    @Override
    public int alterar(Professor entidade) {
       
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

   
}
