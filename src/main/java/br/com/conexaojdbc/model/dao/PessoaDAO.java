package br.com.conexaojdbc.model.dao;

import br.com.conexaojdbc.model.data.Conexao;
import br.com.conexaojdbc.model.entity.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
    private Conexao conexao = null;

    public PessoaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
    }

    public void save(Pessoa pessoa) throws SQLException {
        String statement = "INSERT INTO pessoa(nome, idade, cpf, endereco) value (?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)){

            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setString(3, pessoa.getCpf());
            pstmt.setString(4, pessoa.getEndereco());

            pstmt.execute();
            this.conexao.commit();

        }catch(SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }
}
