package br.edu;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Professor;


public class ProfessorTest {
        public static void main(String[] args) {
                //conexão com banco de dados
                Connection conexao = Conexacao.getConexao();
               
                ProfessorDao ProfessorDao = new ProfessorDao(conexao);
                //consultar toda a tabela(id,professor,email)
                
                ProfessorDao.consultarTodos();
                //vizualizar tabela(professor e curso)
                ProfessorDao.visualizarProfessor();
                
               
                Scanner scan = new Scanner(System.in);

                //entrada de dados
                System.out.println(" Digite o id do professor que deseja alterar: ");
                int Id_alter = scan.nextInt();
                scan.nextLine();

                Professor prof_alter = new Professor();

                //pelo id alterar nome e email
                prof_alter.setId(Id_alter);

                System.out.println("Novo Nome: ");
                prof_alter.setNomeP(scan.nextLine());

                System.out.println("Novo Email: ");
                prof_alter.setEmail(scan.next());

                //alterar professor 
                ProfessorDao.alterar(prof_alter);

                //tabela já atualizada
                ProfessorDao.consultarTodos();
        }
}
