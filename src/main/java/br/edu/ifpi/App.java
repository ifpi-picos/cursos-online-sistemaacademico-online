
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
<<<<<<< HEAD
        Curso ads = new Curso(1, "Análise e Desenvolvimento de Sistemas", StatusCurso.ABERTO, 1200);
        Curso fisica = new Curso(2, "Fisica", StatusCurso.FECHADO, 2200);
=======
        Curso ads = new Curso(1,"Análise e Desenvolvimento de Sistemas", StatusCurso. ABERTO, 1200, 1);
>>>>>>> 8ec78c0e9b69fc721d9d5a13685f34cce3feb648
        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
        // String nome = JOptionPane.showInputDialog("Nome: ");
        // String email = JOptionPane.showInputDialog("Email: ");

<<<<<<< HEAD
        Professor novoProfessor = new Professor("Emilly", "emilly@prof.com");
        Professor novoProfessor1 = new Professor("Kedna", "kedna@prof.com");
        Professor novoProfessor2 = new Professor("Emileny", "emileny@prof.com");

        int retorno = ProfessorDao.cadastrar(novoProfessor);
        int retorno1 = ProfessorDao.cadastrar(novoProfessor1);
        int retorno2 = ProfessorDao.cadastrar(novoProfessor2);

        String mensagem = retorno > 0 ? "Sucesso!" : "Falhou!";
        String mensagem1 = retorno1 > 0 ? "Sucesso!" : "Falhou!";
        String mensagem2 = retorno2 > 0 ? "Sucesso!" : "Falhou!";

               int deleta = ProfessorDao.remover(novoProfessor);
                
               String msm3 = deleta > 0 ? "deu certo" : "nao deu";
         JOptionPane.showMessageDialog(null, msm3, "Retorno", JOptionPane.INFORMATION_MESSAGE);
=======
        //  Professor novoProfessor = new Professor(nome, email);

        // int retorno = ProfessorDao.cadastrar(novoProfessor);

        // String mensagem = retorno > 0 ? "Sucesso!" : "Falhou!";

        // JOptionPane.showMessageDialog(null, mensagem, "Retorno", JOptionPane.INFORMATION_MESSAGE);
>>>>>>> 8ec78c0e9b69fc721d9d5a13685f34cce3feb648

        // JOptionPane.showMessageDialog(null, mensagem, "Retorno",
        // JOptionPane.INFORMATION_MESSAGE);

        // CursoDao CursoDao = new CursoDao(conexao);
        // int cadastrar = CursoDao.cadastrar(fisica);
        // String msm = cadastrar > 0 ? "deu certo" : "deu um erro aqui boy";
        // JOptionPane.showMessageDialog(null, msm, "Retorno", JOptionPane.INFORMATION_MESSAGE);
        // int alterar = CursoDao.alterar(ads);
        // String msm1 = alterar > 0 ? "deu certo" : "deu um erro aqui boy";
        // JOptionPane.showMessageDialog(null, msm1, "Retorno", JOptionPane.INFORMATION_MESSAGE);

        // int deleta = CursoDao.remover(ads);
        // String msm3 = deleta > 0 ? "deu certo" : "nao deu";
        // JOptionPane.showMessageDialog(null, msm3, "Retorno",
        // JOptionPane.INFORMATION_MESSAGE);
    }
}
