package vod.repository.mem;

import vod.model.Nauczyciel;
import vod.model.Szkola;
import vod.model.Lekcja;

import java.util.ArrayList;
import java.util.List;

class Dane {

    static List<Szkola> szkolas = new ArrayList<>();

    static List<Nauczyciel> nauczyciels = new ArrayList<>();

    static List<Lekcja> lekcje = new ArrayList<>();

    static {

        Nauczyciel n1 = new Nauczyciel(1, "Wojciech", "Kowalski");
        Nauczyciel n2 = new Nauczyciel(2, "Patryk", "Myga");
        Nauczyciel n3 = new Nauczyciel(3, "Andrzej", "Gajda");
        Nauczyciel n4 = new Nauczyciel(4, "Jerzy", "Jaworek");

        Lekcja l1 = new Lekcja(1, "Matematyka", n1, 4);
        Lekcja l2 = new Lekcja(2, "Fizyka", n1, 4);

        Lekcja l3 = new Lekcja(3, "Wiedza o spoleczenstwie", n2, 3);
        Lekcja l4 = new Lekcja(4, "Farmakologia", n2, 3);

        Lekcja l5 = new Lekcja(5, "Historia", n3, 5);
        Lekcja l6 = new Lekcja(6, "Mechanika techniczna", n3, 4);

        Lekcja l7 = new Lekcja(7, "Edukacja dla bezpieczeństwa", n4, 5);
        Lekcja l8 = new Lekcja(8, "Jezyk Polski", n4, 4);

        zespol(l1, n1);
        zespol(l2, n1);

        zespol(l3, n2);
        zespol(l4, n2);

        zespol(l5, n3);
        zespol(l6, n3);

        zespol(l7, n4);
        zespol(l8, n4);
        Szkola s3 = new Szkola(3, "s3", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
        Szkola s4 = new Szkola(4, "s4", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");
        Szkola s1 = new Szkola(1, "s1", "https://www.kinoteka.pl/img/logo.png");
        Szkola s2 = new Szkola(2, "s2", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");


        zespol(s1, l2);
        zespol(s3, l2);
        zespol(s3, l1);
        zespol(s3, l3);

        zespol(s1, l6);
        zespol(s4, l6);
        zespol(s4, l7);
        zespol(s2, l7);
        zespol(s2, l3);
        lekcje.add(l6);
        lekcje.add(l3);
        lekcje.add(l5);
        lekcje.add(l7);
        lekcje.add(l8);
        lekcje.add(l1);
        lekcje.add(l2);

        lekcje.add(l4);


        nauczyciels.add(n1);
        nauczyciels.add(n2);
        nauczyciels.add(n3);
        nauczyciels.add(n4);

        szkolas.add(s1);
        szkolas.add(s2);
        szkolas.add(s3);
        szkolas.add(s4);

    }

    private static void zespol(Szkola s, Lekcja l) {
        s.addLekcja(l);
        l.addSzkola(s);
    }

    private static void zespol(Lekcja m, Nauczyciel t) {
        t.addLekcja(m);
        m.setNauczyciel(t);
    }

}
