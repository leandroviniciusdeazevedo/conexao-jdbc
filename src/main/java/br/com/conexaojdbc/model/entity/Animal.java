package br.com.conexaojdbc.model.entity;

public abstract class Animal {

    // propriedades ou atributos
    private String nome;
    private String especie;
    protected int idadeEmMeses;
    protected String sexo;

    public Animal() {
    }

    public Animal(String nome, String especie, int idadeEmMeses, String sexo) {
        this.nome = nome;
        this.especie = especie;
        this.idadeEmMeses = idadeEmMeses;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdadeEmMeses() {
        return idadeEmMeses;
    }

    public void setIdadeEmMeses(int idadeEmMeses) {
        this.idadeEmMeses = idadeEmMeses;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public abstract void som();

    public abstract boolean isAdulto();

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idadeEmMeses +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
