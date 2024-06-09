package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Lekcja {
    private int id;
    private String nazwa_przedmiotu;
    private Nauczyciel nauczyciel;
    private int liczba_godzin;
    @JsonIgnore
    private List<Szkola> szkoly = new ArrayList<>();

    public Lekcja(int id, String nazwa_przedmiotu, Nauczyciel nauczyciel, int liczba_godzin) {
        this.id = id;
        this.nazwa_przedmiotu = nazwa_przedmiotu;
        this.nauczyciel = nauczyciel;
        this.liczba_godzin = liczba_godzin;
    }

    public Lekcja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa_przedmiotu() {
        return nazwa_przedmiotu;
    }

    public void setNazwa_przedmiotu(String nazwa_przedmiotu) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
    }

    public Nauczyciel getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public float getLiczba_godzin() {
        return liczba_godzin;
    }

    public void setLiczba_godzin(int liczba_godzin) {
        this.liczba_godzin = liczba_godzin;
    }

    public List<Szkola> getSzkoly() {
        return szkoly;
    }

    public void setSzkoly(List<Szkola> szkoly) {
        this.szkoly = szkoly;
    }

    public void addSzkola(Szkola c) {
        this.szkoly.add(c);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Lesson{" +
                "przedmiot='" + nazwa_przedmiotu + '\'' +
                ", nauczyciel=" + nauczyciel +
                ", liczba godzin=" + liczba_godzin +
                '}';
    }
}
