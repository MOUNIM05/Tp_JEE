package pres;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("dao", "metier");

        IMetier metier = context.getBean(IMetier.class);

        System.out.println("Résultat = " + metier.calcul());

        context.close();
    }
}
