package vod.repository;

import vod.model.Nauczyciel;

import java.util.List;

public interface NauczycielDao {

    List<Nauczyciel> wszystkie();

    Nauczyciel findById(int id);

    Nauczyciel add(Nauczyciel d);


}
