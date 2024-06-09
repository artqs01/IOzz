package vod.service;

import vod.model.Nauczyciel;
import vod.model.Lekcja;

import java.util.List;

public interface LekcjaService {
    List<Lekcja> getAllLekcje();

    List<Lekcja> getLekcjeByNauczyciel(Nauczyciel d);

    Lekcja getLekcjaById(int id);

    Lekcja addLekcja(Lekcja m);

    List<Nauczyciel> wszyscyNauczycielowie();

    Nauczyciel getNauById(int id);

    Nauczyciel addTeacher(Nauczyciel d);
}