
package br.edu.ifpi;

import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.edu.ifpi.DAO.AlunoDao;
import br.edu.ifpi.DAO.AutenticacaoDao;
import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;



public class App {
    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "true");
        Connection conexao = Conexacao.getConexao();
        AutenticacaoDao autentificacaodao = new AutenticacaoDao(conexao);
        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
        AlunoDao alunoDao = new AlunoDao(conexao);
        String[] opcoes = { "professor", "aluno" };
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu de Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        boolean aux = true;
        if (escolha == 0) {

            String input = JOptionPane.showInputDialog("Digite um seu id :");
            int numero = Integer.parseInt(input);
            autentificacaodao.autenticarProfessor(numero);
            while (aux) {
                String entrada = JOptionPane.showInputDialog(null,
                        "1º cadastrar;\n2ª consultar \n3º vizualizar professores  \n4ª alterar \n5ª remover \n6 ª remover curso \n7ª sair \n DIGITE UMA OPÇÃO:",
                        " Menu", JOptionPane.QUESTION_MESSAGE);

                int opcao = Integer.parseInt(entrada);

                switch (opcao) {

                    case 1:

                        String nome = JOptionPane.showInputDialog("Digite seu nome:");
                        String email = JOptionPane.showInputDialog("Digite um seu email :");

                        Professor cadastrado = new Professor(nome, email);
                        ProfessorDao.cadastrar(cadastrado);
                        JOptionPane.showMessageDialog(null, "O professor foi cadastrado com sucesso! ");

                        break;

                    case 2:

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        break;
                    case 3:

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.visualizarProfessor();
                        System.out.println("-----------------------------------------------------");

                        break;

                    case 4:

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        String id_alter = JOptionPane
                                .showInputDialog("Digite o id do professor que vc desenja alterar: ");
                        int alter_id = Integer.parseInt(id_alter);

                        String nome_alter = JOptionPane.showInputDialog("Digite seu nome:");
                        String email_alter = JOptionPane.showInputDialog("Digite um seu email :");
                        Professor prof_alter = new Professor(nome_alter, email_alter);
                        prof_alter.setId(alter_id);
                        ProfessorDao.alterar(prof_alter);

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        break;
                    case 5:
                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        String id_remov = JOptionPane
                                .showInputDialog("Digite o id do professor que vc desenja remover : ");
                        int remov_id = Integer.parseInt(id_remov);

                        Professor prof_remov = new Professor();
                        prof_remov.setId(remov_id);
                        ProfessorDao.remover(prof_remov);

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        break;
                    case 6:

                        String nome_curso = JOptionPane.showInputDialog("Digite seu nome do curso:");
                        String cargacurso = JOptionPane.showInputDialog("Digite a carga horaria :");
                        int cargahoraria = Integer.parseInt(cargacurso);

                        
                        String id_prof = JOptionPane.showInputDialog("Digite o id do professor:");
                        int id_pro = Integer.parseInt(id_prof);

                        String status = JOptionPane.showInputDialog("Digite o status do curso:");

                        Curso cursinho = new Curso(0, nome_curso, cargahoraria, id_pro, StatusCurso.ABERTO);

                        ProfessorDao.cadastrarCurso(cursinho);

                        break;
                    case 7:

                        JOptionPane.showMessageDialog(null, "saindo do sistema ! ");
                        aux = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "não possui essa opção ! ");

                        break;
                }
            }

        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Você escolheu aluno ");
            String input = JOptionPane.showInputDialog("Digite seu id :");
            int matriculaId = Integer.parseInt(input);
            autentificacaodao.autenticarAluno(matriculaId);

            String entrada = JOptionPane.showInputDialog(null,
                    "1º Matricular;\n2ª consultar \n3º alterar \n4ª cancelar matricula \n5ª Gerar estatisticas \n6 ª visualizar cursos matriculados \n7ª sair \n DIGITE UMA OPÇÃO:",
                    " Menu", JOptionPane.QUESTION_MESSAGE);

            int opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1:
                    String nomeA = JOptionPane.showInputDialog("Digite seu nome:");
                    String emailA = JOptionPane.showInputDialog("Digite um seu email :");

                    Aluno al = new Aluno(nomeA, emailA);
                    alunoDao.cadastrar(al);
                    JOptionPane.showMessageDialog(null, "O professor foi cadastrado com sucesso! ");
                    
                    break;
                case 2: 
                    System.out.println("-----------------------------------------------------");
                    alunoDao.consultarTodos();
                    System.out.println("-----------------------------------------------------");
                break;
                case 3:
                    System.out.println("-----------------------------------------------------");
                    alunoDao.consultarTodos();
                    System.out.println("-----------------------------------------------------");

                    String id_alter = JOptionPane.showInputDialog("Digite o seu id para alterar: ");
                    int alter_id = Integer.parseInt(id_alter);

                    String nome_alter = JOptionPane.showInputDialog("Digite seu nome:");
                    String email_alter = JOptionPane.showInputDialog("Digite um seu email :");
                    Aluno aluno_alter = new Aluno(nome_alter, email_alter);
                    alunoDao.alterar(aluno_alter);
                    System.out.println("alterações realizadas");
                break;
                case 4:
                       System.out.println("-----------------------------------------------------");
                        alunoDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");

                        String id_remov = JOptionPane
                                .showInputDialog("Digite o id do aluno que vc desenja remover : ");
                        int remov_id = Integer.parseInt(id_remov);

                        Aluno aluno_remove = new Aluno();
                        alunoDao.remover(aluno_remove);

                        System.out.println("-----------------------------------------------------");
                        ProfessorDao.consultarTodos();
                        System.out.println("-----------------------------------------------------");
                break;
                case 5: 
                  alunoDao.criarAproveitamentoCurso();
                break;
                case 6 :
                 String varMsm = JOptionPane
                                .showInputDialog("Digite sua matricula : ");
                        int idExibicao = Integer.parseInt(varMsm);

                  alunoDao.exibirCursosMatriculados(idExibicao);
                break;
                case 7:
                aux = false;
                break;
                default:
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
        }

    }
}
