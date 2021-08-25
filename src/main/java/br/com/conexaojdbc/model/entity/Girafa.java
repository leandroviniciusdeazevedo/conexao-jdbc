package br.com.conexaojdbc.model.entity;

public class Girafa extends Animal{
    public Girafa() {
    }

    @Override
    public void som() {
        System.out.println("Relinchando");
    }

    @Override
    public boolean isAdulto() {
        if (this.sexo.equalsIgnoreCase("femea")){
            return idadeEmMeses > 36;
        } else {
            return idadeEmMeses > 60;
        }
    }

    public Girafa(String nome, int idade, String sexo) {
        super(nome, "Girafa", idade, sexo);
    }


}
