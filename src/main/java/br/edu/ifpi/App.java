
package br.edu.ifpi;

import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import br.edu.ifpi.DAO.AutenticacaoDao;
import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
        Connection conexao = Conexacao.getConexao();
        AutenticacaoDao autentificacaodao = new AutenticacaoDao(conexao);
        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
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

        if (escolha == 0) {

            String input = JOptionPane.showInputDialog("Digite um seu id :");
            int numero = Integer.parseInt(input);
            autentificacaodao.autenticarProfessor(numero);

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

                    String id_alter = JOptionPane.showInputDialog("Digite o id que vc desenja alterar: ");
                    int alter_id = Integer.parseInt(id_alter);

                    String nome_alter = JOptionPane.showInputDialog("Digite seu nome:");
                    String email_alter = JOptionPane.showInputDialog("Digite um seu email :");
                    Professor prof_alter = new Professor(nome_alter, email_alter);
                    prof_alter.setId(id_alter);
                    ProfessorDao.alterar(prof_alter);

                    System.out.println("-----------------------------------------------------");
                    ProfessorDao.consultarTodos();
                    System.out.println("-----------------------------------------------------");

                    break;
                case 5:

                    break;
                case 6:
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "saindo do sistema ! ");

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "não possui essa opção ! ");

                    break;
            }

        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Você escolheu aluno ");

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
        }

    }
}