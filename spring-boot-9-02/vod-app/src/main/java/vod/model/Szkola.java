package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Szkola {

    private int id;
    @NotNull
    @Size(min = 2, max = 60)
    private String nazwa;
    private String logo;
    @JsonIgnore
    private List<Lekcja> lekcje = new ArrayList<>();
    public Szkola(int id, String nazwa, String logo) {
        this.id = id;
        this.nazwa = nazwa;
        this.logo = logo;
    }

    public Szkola() {
    }
//settery, gettery i to String - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Lekcja> getLekcje() {
        return lekcje;
    }

    public void setLekcje(List<Lekcja> lekcje) {
        this.lekcje = lekcje;
    }

    public void addLekcja(Lekcja m) {
        this.lekcje.add(m);
    }

    @Override
    public String toString() {
        return "School{" +
                "nazwa='" + nazwa + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
