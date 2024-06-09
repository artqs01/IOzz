package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Szkola;
import vod.repository.SzkolaDao;
import vod.model.Lekcja;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class MemSzkolaDao implements SzkolaDao {

    @Override
    public List<Szkola> wszystkie() {
        return Dane.szkolas;
    }

    @Override
    public Szkola findById(int id) {
        return Dane.szkolas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Szkola> findByLekcja(Lekcja m) {
        return Dane.szkolas.stream().filter(c -> c.getLekcje().contains(m)).collect(Collectors.toList());
    }

    @Override
    public Szkola zapisz(Szkola szkola) {
        Optional<Szkola> optionalSchool= Dane.szkolas.stream()
                .max(Comparator.comparing(Szkola::getId));
        int maxId = 0;
        if(optionalSchool.isPresent()) {
            maxId = optionalSchool.get().getId();
        }
        szkola.setId(maxId);
        Dane.szkolas.add(szkola);
        return szkola;
    }
}
