package br.edu.ifpi;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.AutenticacaoDao;
import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;


public class ProfessorTest {
        public static void main(String[] args) {
                //CONEXÃO COM BANCO DE DADOS
                Connection conexao = Conexacao.getConexao();

                ProfessorDao ProfessorDao = new ProfessorDao(conexao);

//AUTENFIFICAÇÃO DO PROFESSOR 

                AutenticacaoDao autentificacaodao= new AutenticacaoDao(conexao);

                Professor altentica_prof= autentificacaodao.autenticarProfessor(89);
//CONSULTAR TODA TABELA

                 ProfessorDao.consultarTodos();

                //VIZUALIZAR PROFESSORES E CURSOS 

            ProfessorDao.visualizarProfessor();
              
               
                Scanner scan = new Scanner(System.in);

                //ENTRADA DO ID PARA ALTERAÇÃO

                // System.out.println(" Digite o id do professor que deseja alterar: ");
                // int Id_alter = scan.nextInt();
                // scan.nextLine();

                // Professor prof_alter = new Professor();

                // ALTERAR PELO ID COLETADO

                // prof_alter.setId(Id_alter);

                // System.out.println("Novo Nome: ");
                // prof_alter.setNomeP(scan.nextLine());

                // System.out.println("Novo Email: ");
                // prof_alter.setEmail(scan.next());

                // ALTERAR PROFESSOR SELECIONADO 

                // ProfessorDao.alterar(prof_alter);

                // ENTRADA DE ID PARA REMOÇÃO 

                // System.out.println(" Digite o id do professor que deseja remover: ");
                // int Id_remov = scan.nextInt();
                

                // Professor prof_remov= new Professor();
                // prof_remov.setId((Id_remov));

                // REMOVE PROFESSOR SELECIONADO 

                // ProfessorDao.remover(prof_remov);

                // INSTANCIA NOVO CURSO 
                 Curso cursinho= new Curso(0, "Engenharia de Software", 60, 1, StatusCurso.ABERTO);
                
                 //CADASTRA NOVO CURSO 

                 // ProfessorDao.cadastrarCurso(cursinho);

                 //VOLTA A MOSTRAR TABELA COMPLETA 

                // ProfessorDao.consultarTodos();
        }
}
