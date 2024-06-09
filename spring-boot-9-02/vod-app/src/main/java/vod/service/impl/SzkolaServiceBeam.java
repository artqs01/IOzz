package vod.service.impl;

import org.springframework.stereotype.Service;
import vod.model.Szkola;
import vod.model.Lekcja;
import vod.repository.SzkolaDao;
import vod.repository.LekcjaDao;
import vod.service.SzkolaService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SzkolaServiceBeam implements SzkolaService {

    private static final Logger log = Logger.getLogger(SzkolaService.class.getName());

    private SzkolaDao szkolaDao;
    private LekcjaDao lekcjaDao;

    public SzkolaServiceBeam(SzkolaDao szkolaDao, LekcjaDao lekcjaDao) {
        log.info("SzkolaServiceBeam");
        this.szkolaDao = szkolaDao;
        this.lekcjaDao = lekcjaDao;
    }

    @Override
    public Szkola getSzkolaById(int id) {
        log.info("getSzkolaById " + id);
        return szkolaDao.findById(id);
    }

    @Override
    public List<Lekcja> getLekcjeWSzkole(Szkola c) {
        log.info("getLekcjeWSzkole " + c.getId());
        return lekcjaDao.findbySzkola(c);
    }

    @Override
    public Szkola addSzkola(Szkola szkola) {
        log.info("addSzkola");
        return szkolaDao.zapisz(szkola);
    }

    @Override
    public List<Szkola> getAllSzkoly() {
        log.info("getAllSzkoly");
        return szkolaDao.wszystkie();
    }

    @Override
    public List<Szkola> getSzkolaByLekcja(Lekcja m) {
        log.info("getSzkolaByLekcja " + m.getId());
        return szkolaDao.findByLekcja(m);
    }

}
