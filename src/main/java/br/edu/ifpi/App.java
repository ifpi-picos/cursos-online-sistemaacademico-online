
package br.edu.ifpi;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.DAO.CursoDao;
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

        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
        

        Professor novoProfessor = new Professor("Cakelin", "Cat@prof.com");
        Professor novoProfessor1 = new Professor("Valeria", "valeria@prof.com");

        int retorno = ProfessorDao.cadastrar(novoProfessor);
        int retorno1 = ProfessorDao.cadastrar(novoProfessor1);

        String mensagem = retorno > 0 ? "Sucesso!" : "Falhou!";
        JOptionPane.showMessageDialog(null, mensagem, "Retorno", JOptionPane.INFORMATION_MESSAGE);
        
        
        int msg = ProfessorDao.remover(novoProfessor);
        String mnsg = msg > 0 ? "Sucesso!" : "Falhou!";
        JOptionPane.showMessageDialog(null, mnsg, "Retorno", JOptionPane.INFORMATION_MESSAGE);

       
    }
}
