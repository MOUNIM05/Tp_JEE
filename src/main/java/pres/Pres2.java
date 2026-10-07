package pres;

import dao.IDao;
import metier.IMetier;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Pres2 {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Pres2.class.getClassLoader().getResourceAsStream("config.txt");

        if (inputStream == null) {
            throw new IllegalStateException("config.txt introuvable dans le classpath");
        }

        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);

        String daoClassName = scanner.nextLine();
        String metierClassName = scanner.nextLine();

        Class<?> daoClass = Class.forName(daoClassName);

        IDao dao = (IDao) daoClass
                .getDeclaredConstructor()
                .newInstance();

        Class<?> metierClass = Class.forName(metierClassName);

        IMetier metier = (IMetier) metierClass
                .getDeclaredConstructor()
                .newInstance();

        Method setDao = metierClass.getMethod("setDao", IDao.class);
        setDao.invoke(metier, dao);

        System.out.println("Résultat = " + metier.calcul());

        scanner.close();
    }
}
