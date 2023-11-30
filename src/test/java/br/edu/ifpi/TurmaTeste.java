package br.edu.ifpi;
import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.CursoAlunoDao;
import br.edu.ifpi.entidades.CursoAluno;

public class TurmaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conexao = Conexacao.getConexao();
        CursoAlunoDao turmaDao = new CursoAlunoDao(conexao);
        // MÉTODO CADASTRAR
        // Turma t1 = new Turma(1,2, 9.7);
        // Turma t2 = new Turma(1,1, 8);
        // turmaDao.cadastrar(t2);
        turmaDao.consultarTodos();

        // MÉTODO ALTERAR NOTA PELO ID DO ALUNO
        System.out.print("Digite o ID do aluno a ser alterado: ");
        int alteracao = scanner.nextInt();

        scanner.nextLine();

        CursoAluno turmaalterado = new CursoAluno();

        turmaalterado.setId_aluno(alteracao);

        System.out.println("novo id do aluno: ");
        turmaalterado.setId_aluno(scanner.nextInt());

        System.out.println("novo id curso: ");
        turmaalterado.setId_curso(scanner.nextInt());

        System.out.println("nova nota: ");
        turmaalterado.setNota(scanner.nextDouble());
        turmaDao.alterar(turmaalterado);

        // MÉTODO REMOVER 
        //   System.out.print("Digite o ID do aluno a ser removido da turma: ");
        //  int idParaRemover = scanner.nextInt();
        //  Turma alunoRemovidoTurma = new Turma();
        //   alunoRemovidoTurma.setId_aluno(idParaRemover);
        //   turmaDao.remover(alunoRemovidoTurma);

           // MÉTODO PARA EXIBIR TOTAL DE ALUNOS POR O ID DO CURSO
        //    System.out.print("digite o  id do curso para saber a quantidade de alunos: ");
        //    int qtd = scanner.nextInt();
        //    cursodao.exibirAlunosMatriculados(qtd);

        turmaDao.gerarSituacao();
        }
}
