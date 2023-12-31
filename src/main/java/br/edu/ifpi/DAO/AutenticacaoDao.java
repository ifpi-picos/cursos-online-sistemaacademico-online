package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;

public class AutenticacaoDao {
    private Connection conexao;

    public AutenticacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public Aluno autenticarAluno(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int id_a = resultSet.getInt("id");
                String nome_a = resultSet.getString("nome");
                String email_a = resultSet.getString("email");
        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema Academico " + nome_a +" !", "Deu certo, boy!", JOptionPane.INFORMATION_MESSAGE);

                return new Aluno(id_a, nome_a, email_a);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
               JOptionPane.showMessageDialog(null,"Aluno não encontrado!","Não deu certo não, boy!", JOptionPane.ERROR_MESSAGE);

        return null;
    }

    public Professor autenticarProfessor(int id) {
        String SQLP = "SELECT * FROM professor WHERE id = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(SQLP);
            stm.setInt(1, id);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                int id_p = resultSet.getInt("id");
                String nome_p = resultSet.getString("nome");
                String email_p = resultSet.getString("email");
        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema Academico " + nome_p +" !", "Deu certo, boy!", JOptionPane.INFORMATION_MESSAGE);

                return new Professor(id_p, nome_p, email_p);

            }

        } catch (Exception e) {
            e.printStackTrace();
 
        }

       JOptionPane.showMessageDialog(null,"Professor não encontrado!","Não deu certo não, boy!", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}