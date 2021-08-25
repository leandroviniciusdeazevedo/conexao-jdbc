package br.com.conexaojdbc.model.entity;

public class Produto {
    private String nome;
    private String fornecedor;
    private Double preco;
    private Integer qtdEstoque;

    public Produto() {
    }

    public Produto(String nome, String fornecedor, Double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", preco=" + preco +
                ", estoque='" + qtdEstoque + '\'' +
                '}';
    }
}
