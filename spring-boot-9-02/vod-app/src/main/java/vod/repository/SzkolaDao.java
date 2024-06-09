package vod.repository;

import vod.model.Szkola;
import vod.model.Lekcja;

import java.util.List;

public interface SzkolaDao {

    List<Szkola> wszystkie();

    Szkola findById(int id);

    List<Szkola> findByLekcja(Lekcja m);

    Szkola zapisz(Szkola szkola);
}
