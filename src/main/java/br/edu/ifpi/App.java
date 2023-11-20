
package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        

        Professor novoProfessor1 = new Professor("zé", "789@prof.com");

        int retorno1 = ProfessorDao.cadastrar(novoProfessor1);

        String mensagem = retorno1 > 0 ? "Sucesso!" : "Falhou!";
        JOptionPane.showMessageDialog(null, mensagem, "Retorno", JOptionPane.INFORMATION_MESSAGE);
        
                        

//          // Consultar todos os professores
//             List<Professor> professores = ProfessorDao.consultarTodos();

//             // Exibir os resultados
//             System.out.println("Lista de Professores:");
//             for (Professor professor : professores) {
//                 System.out.println("ID: " + professor.getId() + ", Nome: " + professor.getNome() + ", Email: " + professor.getEmail());
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//             System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
//         }
//     }
// }
        List<Professor> profs = ProfessorDao.consultarTodos();
        
        int i = 0;
        while(i <= profs.size()) {
            System.out.println("Nome: " + profs.get(i).getNome());
            i++;
        }
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();

        Professor profRemover = profs.get(opcao-1);

        int msg = ProfessorDao.remover(profRemover);

        String mnsg = msg > 0 ? "Sucesso!" : "Falhou!";
        JOptionPane.showMessageDialog(null, mnsg, "Retorno", JOptionPane.INFORMATION_MESSAGE);

       
    

    }
}