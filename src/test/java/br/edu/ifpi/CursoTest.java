package br.edu.ifpi;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.CursoDao;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.enums.StatusCurso;

public class CursoTest {

  // Curso cursoPadrao = null;


  // @Before
  // public void setup() {
  // cursoPadrao =
  // new Curso("Padrão", StatusCurso.ABERTO, 80, new Professor("Professor", 1, "89999"));
  // }

  // @Test
  // public void cursoAbertoDeveAceitarMatriculaDeAluno() {
  // Aluno aluno = new Aluno("Aluno", 0, "899999");
  // assertTrue(cursoPadrao.getAlunos().size() == 0);
  // cursoPadrao.realizaMatricula(aluno);
  // assertTrue(cursoPadrao.getAlunos().size() == 1);
  // }

  // @Test
  // public void cursoFechadoDeveRecusarMatriculaDeAluno() {
  // Aluno aluno = new Aluno("Aluno", 0, "899999");
  // cursoPadrao.setStatus(StatusCurso.FECHADO);
  // cursoPadrao.realizaMatricula(aluno);
  // assertTrue(cursoPadrao.getAlunos().size() == 0);
  // }

  public static void main(String[] args) {
    // main de testes da classe CursoDao
        Connection conexao = Conexacao.getConexao();
        CursoDao cursodao = new CursoDao(conexao);

        // Curso c1 = new Curso(0, "Poo", 80, 9, StatusCurso.FECHADO);
        // Curso c2 = new Curso(0, "IA", 15, 9, StatusCurso.FECHADO);

        // cursodao.cadastrar(c1);
        // cursodao.cadastrar(c2);
        // cursodao.consultarTodos();
        cursodao.visualizarCursos();

        Scanner scanner = new Scanner(System.in);
        // System.out.print("Digite o ID do curso a ser removido: ");
        // int idParaRemover = scanner.nextInt();
        // Curso cursoParaRemover = new Curso();
        // cursoParaRemover.setId(idParaRemover);
 
        // System.out.print("Digite o ID do curso a ser alterado: ");
        // int alteracao = scanner.nextInt();

        // scanner.nextLine();

        // Curso cursoalterado = new Curso();

        // cursoalterado.setId(alteracao);
        // System.out.println("novo nome: ");
        // cursoalterado.setNome(scanner.nextLine());

        // System.out.println("staus do curso");
        // cursoalterado.setStatus(StatusCurso.valueOf(scanner.next()));

        // System.out.println("nova carga horaria: ");
        // cursoalterado.setCargahoraria(scanner.nextInt());

        // System.out.println("novo professor: ");
        // cursoalterado.setProf_id(scanner.nextInt());
        // cursodao.alterar(cursoalterado);

        System.out.println("qual o curso deseja atualizar a media?  ");
        int idCurso = scanner.nextInt();
        cursodao.calcularMediaGeral(idCurso);
}};
