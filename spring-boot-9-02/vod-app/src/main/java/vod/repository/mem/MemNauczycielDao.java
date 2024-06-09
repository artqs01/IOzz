package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.model.Nauczyciel;
import vod.repository.NauczycielDao;

import java.util.List;
@Repository
public class MemNauczycielDao implements NauczycielDao {
    @Override
    public List<Nauczyciel> wszystkie() {
        return Dane.nauczyciels;
    }

    @Override
    public Nauczyciel findById(int id) {
        return Dane.nauczyciels.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Nauczyciel add(Nauczyciel d) {
        int max = Dane.nauczyciels.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        Dane.nauczyciels.add(d);
        return d;
    }
}
