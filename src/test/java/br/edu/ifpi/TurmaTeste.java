package br.edu.ifpi;
import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.TurmaDao;
import br.edu.ifpi.entidades.Turma;

public class TurmaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conexao = Conexacao.getConexao();
        TurmaDao turmaDao = new TurmaDao(conexao);
        // MÉTODO CADASTRAR
        // Turma t1 = new Turma(1,2, 9.7);
        // Turma t2 = new Turma(5,3, 3.4);
        // turmaDao.cadastrar(t2);
        // turmaDao.consultarTodos();
        // turmaDao.gerarEstaticas();

        // MÉTODO ALTERAR NOTA PELO ID DO ALUNO
        // System.out.print("Digite o ID do aluno a ser alterado: ");
        // int alteracao = scanner.nextInt();

        // scanner.nextLine();

        // Turma turmaalterado = new Turma();

        // turmaalterado.setId_aluno(alteracao);

        // System.out.println("novo id do aluno: ");
        // turmaalterado.setId_aluno(scanner.nextInt());

        // System.out.println("novo id curso: ");
        // turmaalterado.setId_curso(scanner.nextInt());

        // System.out.println("nova nota: ");
        // turmaalterado.setNota(scanner.nextDouble());
        // turmaDao.alterar(turmaalterado);
        
        turmaDao.gerarEstaticas();
        turmaDao.consultarTodos();

        // MÉTODO REMOVER 
        //   System.out.print("Digite o ID do aluno a ser removido da turma: ");
        //  int idParaRemover = scanner.nextInt();
        //  Turma alunoRemovidoTurma = new Turma();
        //   alunoRemovidoTurma.setId_aluno(idParaRemover);
        //   turmaDao.remover(alunoRemovidoTurma);
        }
}
