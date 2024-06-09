package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Lekcja;
import vod.model.Szkola;
import vod.repository.SzkolaDao;

import java.util.List;

@Component
public class DummySzkolaDao implements SzkolaDao {
	@Override
	public List<Szkola> wszystkie() {
		return List.of();
	}

	@Override
	public Szkola findById(int id) {
		return null;
	}

	@Override
	public List<Szkola> findByLekcja(Lekcja m) {
		return List.of();
	}

	@Override
	public Szkola zapisz(Szkola szkola) {
		return null;
	}
}
