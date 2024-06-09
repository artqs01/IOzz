package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vod.model.Nauczyciel;
import vod.repository.SzkolaDao;
import vod.repository.NauczycielDao;
import vod.repository.LekcjaDao;
import vod.model.Szkola;
import vod.model.Lekcja;
import vod.service.LekcjaService;

import java.util.List;
import java.util.logging.Logger;
@Service
public class LekcjaServiceBeam implements LekcjaService {

    private static final Logger log = Logger.getLogger(LekcjaService.class.getName());

    @Autowired
    public void setNauDao(NauczycielDao nauczycielDao) {
        this.nauczycielDao = nauczycielDao;
    }

    private NauczycielDao nauczycielDao;
    private SzkolaDao szkolaDao;
    private LekcjaDao lekcjaDao;

    public LekcjaServiceBeam(NauczycielDao nauczycielDao, SzkolaDao szkolaDao, LekcjaDao lekcjaDao) {
        this.nauczycielDao = nauczycielDao;
        this.szkolaDao = szkolaDao;
        this.lekcjaDao = lekcjaDao;
    }

    public List<Lekcja> getAllLekcje() {
        log.info("getAllLekcje");
        return lekcjaDao.wszystkie();
    }

    public List<Lekcja> getLekcjeByNauczyciel(Nauczyciel d) {
        log.info("getLekcjeByNauczyciel " + d.getId());
        return lekcjaDao.findByNauczyciel(d);
    }

    public List<Lekcja> getLekcjeBySzkola(Szkola c) {
        log.info("getLekcjeBySzkola " + c.getId());
        return lekcjaDao.findbySzkola(c);
    }

    public Lekcja getLekcjaById(int id) {
        log.info("getLekcjaById " + id);
        return lekcjaDao.findById(id);
    }

    public List<Szkola> wszystkieSzkoly() {
        log.info("wszystkieSzkoly");
        return szkolaDao.wszystkie();
    }

    public List<Szkola> getSzkolaByLekcja(Lekcja m) {
        log.info("getSzkolaByLekcja " + m.getId());
        return szkolaDao.findByLekcja(m);
    }

    public Szkola getSkolaById(int id) {
        log.info("getSkolaById " + id);
        return szkolaDao.findById(id);
    }

    public List<Nauczyciel> wszyscyNauczycielowie() {
        log.info("wszyscyNauczycielowie");
        return nauczycielDao.wszystkie();
    }

    public Nauczyciel getNauById(int id) {
        log.info("getNauById " + id);
        return nauczycielDao.findById(id);
    }

    @Override
    public Lekcja addLekcja(Lekcja m) {
        log.info("addLekcja " + m);
        return lekcjaDao.add(m);
    }

    @Override
    public Nauczyciel addTeacher(Nauczyciel d) {
        log.info("about to add teacher " + d);
        return nauczycielDao.add(d);
    }

}
