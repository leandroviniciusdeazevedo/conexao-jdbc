package br.com.conexaojdbc;

import br.com.conexaojdbc.model.dao.AnimalDAO;
import br.com.conexaojdbc.model.entity.Animal;
import br.com.conexaojdbc.model.entity.Cachorro;
import br.com.conexaojdbc.model.entity.Gato;
import br.com.conexaojdbc.model.entity.Girafa;
import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLException;

public class TestePrincipal {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Animal c = new Gato("Jojo", 12, "femea");
        System.out.println(c);
        c.som();
        AnimalDAO dao = new AnimalDAO();
        dao.save(c);

        Animal gc = new Girafa("Juju", 60, "femea");
        System.out.println(gc);
        gc.som();
        if(gc.isAdulto()){
            System.out.println("Adulto");
        } else {
            System.out.println("Filhote");
        }
        AnimalDAO dao2 = new AnimalDAO();
        dao2.save(gc);

        Animal a = new Cachorro("GO", 36, "macho");
        System.out.println(a);
        a.som();
        AnimalDAO dao3 = new AnimalDAO();
        dao3.save(a);
    }
}
