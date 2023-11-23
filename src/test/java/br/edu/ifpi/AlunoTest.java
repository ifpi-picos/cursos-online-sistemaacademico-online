package br.edu.ifpi;

import java.sql.Connection;

import br.edu.ifpi.DAO.AlunoDao;
import br.edu.ifpi.DAO.Conexacao;

public class AlunoTest{



public static  void main(String [] args){
    Connection conexao = Conexacao.getConexao();
    AlunoDao alunoConexao = new AlunoDao(conexao);
    // Aluno aluno1 = new Aluno("samya", "sam@aluno.ifpi.edu.br");
        // alunoConexao.cadastrar(aluno1);
        // Aluno al2 = new Aluno("Katarina", "katarina@aluno.ifpi.edu.br");
        // alunoConexao.cadastrar(al2);

        alunoConexao.consultarTodos();

    
}

}