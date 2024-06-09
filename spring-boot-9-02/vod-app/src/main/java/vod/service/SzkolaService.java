package vod.service;

import vod.model.Szkola;
import vod.model.Lekcja;

import java.util.List;

public interface SzkolaService {
    Szkola getSzkolaById(int id);

    List<Szkola> getAllSzkoly();

    List<Szkola> getSzkolaByLekcja(Lekcja m);

    List<Lekcja> getLekcjeWSzkole(Szkola c);

    Szkola addSzkola(Szkola szkola);
}
