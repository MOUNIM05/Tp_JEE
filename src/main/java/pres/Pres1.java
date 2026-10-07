package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.MetierImpl;

public class Pres1 {

    public static void main(String[] args) {

        IDao dao = new DaoImpl();

        MetierImpl metier = new MetierImpl();

        metier.setDao(dao);

        System.out.println("Résultat = " + metier.calcul());
    }
}
