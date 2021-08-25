package br.com.conexaojdbc.model.entity;

public class Cachorro extends Animal{
    public Cachorro() {
    }

    @Override
    public void som() {
        System.out.println("Latindo");
    }

    @Override
    public boolean isAdulto() {
        return this.idadeEmMeses > 24;
    }

    public Cachorro(String nome, int idade, String sexo) {
        super(nome, "Cachorro", idade, sexo);
    }


}
