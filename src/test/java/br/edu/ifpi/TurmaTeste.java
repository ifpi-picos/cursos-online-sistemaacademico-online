package br.edu.ifpi;
import java.sql.Connection;

import br.edu.ifpi.DAO.Conexacao;
import br.edu.ifpi.DAO.TurmaDao;
import br.edu.ifpi.entidades.Turma;

public class TurmaTeste {
    public static void main(String[] args) {
        Connection conexao = Conexacao.getConexao();
        TurmaDao turmaDao = new TurmaDao(conexao);
        Turma t1 = new Turma(1,2, 9.7);
        Turma t2 = new Turma(2,3, 8.7);
        turmaDao.cadastrar(t2);
        }
}
