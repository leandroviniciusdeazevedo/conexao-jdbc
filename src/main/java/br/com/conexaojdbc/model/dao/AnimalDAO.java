package br.com.conexaojdbc.model.dao;

import br.com.conexaojdbc.model.data.Conexao;
import br.com.conexaojdbc.model.entity.Animal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe que irá conecatar a informacao do user com o banco
// DAO = Data Access Object
public class AnimalDAO {
    private Conexao conexao = null;

    public AnimalDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new Conexao();
    }

    public void save(Animal animal) throws SQLException {
        String statement = "INSERT INTO animal(nome, especie, idade, sexo) values (?, ?, ?,?)";
        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            pstmt.setString(1, animal.getNome());
            pstmt.setString(2, animal.getEspecie());
            pstmt.setInt(3, animal.getIdadeEmMeses());
            pstmt.setString(4, animal.getSexo());
            pstmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    /*public List<Animal> findAll() throws SQLException {
        String statement = "select id, nome, especie, idade, sexo from animal;";

        try (PreparedStatement pstmt = this.conexao.getConnection().prepareStatement(statement)) {
            ResultSet resultSet = pstmt.executeQuery();
            List<Animal> animalList = new ArrayList<>();
            while (resultSet.next()){
                Animal animalBuscado = new Animal(
                        resultSet.getString("nome"),
                        resultSet.getString("especie"),
                        resultSet.getInt("idade"),
                        resultSet.getString("sexo"));
                animalList.add(animalBuscado);
            }
            return animalList;
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }*/

    public void update(String nomeAlterado, int id) throws SQLException {
        String statement = "update animal set nome = ? where id = ?;";
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
        String statement = "delete from animal where id = ?;";
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
