package br.edu;

import java.sql.Connection;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.ProfessorDao;

public class ProfessorTest {
public static void main(String[] args) {
     Connection conexao = Conexacao.getConexao();

        ProfessorDao ProfessorDao = new ProfessorDao(conexao);
        ProfessorDao.visualizarProfessor();
        ProfessorDao.consultarTodos();

}
}
