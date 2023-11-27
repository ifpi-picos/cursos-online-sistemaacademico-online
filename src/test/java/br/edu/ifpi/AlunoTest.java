package br.edu.ifpi;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.AlunoDao;
import br.edu.ifpi.DAO.AutenticacaoDao;
import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.entidades.Aluno;

public class AlunoTest {

    public static void main(String[] args) {
        Connection conexao = Conexacao.getConexao();
        AlunoDao alunoConexao = new AlunoDao(conexao);
        AutenticacaoDao autentificacaodao = new AutenticacaoDao(conexao);
        Aluno altentica_alu = autentificacaodao.autenticarAluno(3);
        // Aluno aluno1 = new Aluno("samya", "sam@aluno.ifpi.edu.br");
        // alunoConexao.cadastrar(aluno1);
        // Aluno al2 = new Aluno("Katarina", "katarina@aluno.ifpi.edu.br");
        // alunoConexao.cadastrar(al2);

        //alunoConexao.consultarTodos();

         Scanner scanner = new Scanner(System.in);
        // System.out.println("Digite o id do aluno");
        // int Id_alter = scanner.nextInt();
        // scanner.nextLine();

        // Aluno aluno_alter = new Aluno();
        // aluno_alter.setId_aluno(Id_alter);

        // System.out.println("Novo Nome: ");
        // aluno_alter.setNome(scanner.nextLine());

        // System.out.println("Novo Email: ");
        // aluno_alter.setEmail(scanner.next());

        // alunoConexao.alterar(aluno_alter);

        // Aluno aluno_remover = new Aluno();
        // System.out.println("Digite o id do aluno que deseja remover: ");
        // int id_remove = scanner.nextInt();

        // aluno_remover.setId_aluno((id_remove));

        // alunoConexao.remover(aluno_remover);
        // alunoConexao.consultarTodos();

       // alunoConexao.gerarEstaticas();
       // alunoConexao.consultarTodos();
       alunoConexao.visualizarCursos();
    }

}