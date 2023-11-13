
package br.edu.ifpi;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Sistema de cursos online!");
        Connection conexao = Conexacao.getConexao();
        Curso ads = new Curso("Análise e Desenvolvimento de Sistemas", StatusCurso. ABERTO, 1200);
        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
         String nome = JOptionPane.showInputDialog("Nome: ");
         String email = JOptionPane.showInputDialog("Email: ");
         String id = JOptionPane.showInputDialog("Curso: ");

         Professor novoProfessor = new Professor(nome, null, ads);

        int retorno = ProfessorDao.cadastrar(novoProfessor);

        String mensagem = retorno > 0 ? "Sucesso!" : "Falhou!";

        JOptionPane.showMessageDialog(null, mensagem, "Retorno", JOptionPane.INFORMATION_MESSAGE);

      
     }
}
