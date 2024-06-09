package vod.repository;

import vod.model.Nauczyciel;
import vod.model.Szkola;
import vod.model.Lekcja;

import java.util.List;

public interface LekcjaDao {

    List<Lekcja> wszystkie();

    Lekcja findById(int id);

    List<Lekcja> findByNauczyciel(Nauczyciel d);

    List<Lekcja> findbySzkola(Szkola c);

    Lekcja add(Lekcja m);

}
