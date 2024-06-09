package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.model.Nauczyciel;
import vod.model.Szkola;
import vod.repository.LekcjaDao;
import vod.model.Lekcja;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class MemLekcjaDao implements LekcjaDao {
    @Override
    public List<Lekcja> wszystkie() {
        return Dane.lekcje;
    }

    @Override
    public Lekcja findById(int id) {
        return Dane.lekcje.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Lekcja> findByNauczyciel(Nauczyciel d) {
       return Dane.lekcje.stream().filter(m -> m.getNauczyciel() == d).collect(Collectors.toList());
    }

    @Override
    public List<Lekcja> findbySzkola(Szkola c) {
        return Dane.lekcje.stream().filter(m -> m.getSzkoly().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Lekcja add(Lekcja m) {
        int max = Dane.lekcje.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        max++;
        m.setId(max);
        Dane.lekcje.add(m);
        return m;
    }
}
