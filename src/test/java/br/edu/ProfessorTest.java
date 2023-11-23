package br.edu;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Professor;


public class ProfessorTest {
        public static void main(String[] args) {
                Connection conexao = Conexacao.getConexao();

                ProfessorDao ProfessorDao = new ProfessorDao(conexao);
                ProfessorDao.consultarTodos();
                ProfessorDao.visualizarProfessor();
                // ProfessorDao.alterar();
                Scanner scan = new Scanner(System.in);
                System.out.println(" Digite o id do professor que 7deseja alterar: ");
                int Id_alter = scan.nextInt();
                scan.nextLine();

                Professor prof_alter = new Professor();

                prof_alter.setId(Id_alter);
                System.out.println("Novo Nome: ");
                prof_alter.setNomeP(scan.nextLine());

                System.out.println("Novo Email: ");
                prof_alter.setEmail(scan.next());

                
                ProfessorDao.alterar(prof_alter);

                ProfessorDao.consultarTodos();
        }
}
