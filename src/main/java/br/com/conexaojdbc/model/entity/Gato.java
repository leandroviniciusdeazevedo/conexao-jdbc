package br.com.conexaojdbc.model.entity;

public class Gato extends Animal{
    public Gato(){
    }

    @Override
    public void som() {
        System.out.println("Miando");
    }

    @Override
    public boolean isAdulto() {
        return this.idadeEmMeses > 12;
    }

    public Gato(String nome, int idade, String sexo) {
        super(nome, "Gato", idade, sexo);
    }


}
