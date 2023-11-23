
package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.edu.ifpi.DAO.AlunoDao;
import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.DAO.CursoDao;
import br.edu.ifpi.entidades.Aluno;
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
        CursoDao cursoDao = new CursoDao(conexao);
        AlunoDao alunoConexao = new AlunoDao(conexao);

        // Professor novoProfessor1 = new Professor("zé", "789@prof.com");
        // Professor novoProfessor2 = new Professor("João", "joao@prof.com");
        // Professor novoProfessor3 = new Professor("Pedro", "pedro@prof.com");

        // ProfessorDao.cadastrar(novoProfessor1);
        // ProfessorDao.cadastrar(novoProfessor2);
        // ProfessorDao.cadastrar(novoProfessor3);
        // ProfessorDao.consultarTodos();

        Curso curso = new Curso(4, "Algoritmo", 100, 1, StatusCurso.ABERTO);
        // cursoDao.cadastrar(curso);
        cursoDao.consultarTodos();
        cursoDao.visualizarCursos();

        CursoDao dao = new CursoDao(conexao);
        Curso novoCurso = new Curso(4, "Poo", 60, 3, StatusCurso.ABERTO);
        // dao.cadastrar(novoCurso);
        List<Curso> cursos = dao.consultarTodos();

        for (Curso c : cursos) {
            System.out.println("id " + curso.getId());
            System.out.println("nome " + curso.getNome());
        }

        Aluno aluno1 = new Aluno("samya", "sam@aluno.ifpi.edu.br");
        // alunoConexao.cadastrar(aluno1);
        Aluno al2 = new Aluno("Katarina", "katarina@aluno.ifpi.edu.br");
       // alunoConexao.cadastrar(al2);

        // int i = 0;
        // while (i <= profs.size()) {
        // System.out.println("Nome: " + profs.get(i).getNome());
        // i++;
        // }

    }
}