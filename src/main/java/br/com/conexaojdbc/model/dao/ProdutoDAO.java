package br.com.conexaojdbc.model.dao;

import br.com.conexaojdbc.model.data.Conexao;
import br.com.conexaojdbc.model.entity.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe que irá conecatar a informacao do user com o banco
// DAO = Data Access Object
public class ProdutoDAO {
    private Conexao conexao = null;

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
    }

    public void save(Produto produto) throws SQLException {
        String statement = "INSERT INTO produto(nome, fornecedor, preco, qtdEstoque) values (?, ?, ?,?)";
        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getFornecedor());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQtdEstoque());
            pstmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public List<Produto> findAll() throws SQLException {
        String statement = "select id, nome, fornecedor, preco, qtdEstoque from produto;";

        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            ResultSet resultSet = pstmt.executeQuery();
            List<Produto> produtoList = new ArrayList<>();
            while (resultSet.next()){
                Produto produtoBuscado = new Produto(
                        resultSet.getString("nome"),
                        resultSet.getString("fornecedor"),
                        resultSet.getDouble("preco"),
                        resultSet.getInt("qtdEstoque"));
                produtoList.add(produtoBuscado);
            }
            return produtoList;
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void update(String nomeAlterado, int id) throws SQLException {
        String statement = "update produto set nome = ? where id = ?;";
        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            pstmt.setString(1, nomeAlterado);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

    }

    public void delete(int id) throws SQLException {
        String statement = "delete from produto where id = ?;";
        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

    }
}
