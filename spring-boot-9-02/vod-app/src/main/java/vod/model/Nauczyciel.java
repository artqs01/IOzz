package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Nauczyciel {

    private int id;
    private String imie;
    private String nazwisko;
    @JsonIgnore
    private List<Lekcja> lekcje = new ArrayList<>();//relacja 1 do wielu
//listy zeby przey przełączniu na SpringDate nie było komplikacji
//lista od seta różni się tym że są w niej powtórzenia oraz trzymamy kolejność wrzucania
    //struktury danych wazna rzecz w zachowaniu spójności danych w warstwie aplikacyjnej
    public Nauczyciel(int id, String Imie, String nazwisko) {
        this.id = id;
        this.imie = Imie;
        this.nazwisko = nazwisko;
    }

    public Nauczyciel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
        return "Nauczyciel{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
