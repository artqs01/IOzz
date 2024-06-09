package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Lekcja;
import vod.model.Szkola;
import vod.service.LekcjaService;
import vod.service.SzkolaService;
import vod.web.rest.dto.LessonDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class LessonRest {

    private final LekcjaService lekcjaService;
    private final SzkolaService szkolaService;

    @GetMapping("/lessons")
    ResponseEntity<List<Lekcja>> getLessons(){
        List<Lekcja> lessons = lekcjaService.getAllLekcje();
        log.info("{} znalezionych lekcji", lessons.size());
        lessons.forEach(lesson -> log.info("{}", lesson));
        return ResponseEntity.ok().body(lessons);
    }
    @GetMapping("/lessons/{id}")
    ResponseEntity<Lekcja> getLessonById(@PathVariable("id") int id){
        Lekcja lesson = lekcjaService.getLekcjaById(id);
        if(lesson != null){
            log.info("{} znaleziono lekcje", lesson.getNazwa_przedmiotu() );
            return ResponseEntity.ok(lesson);
        }else {
            log.info("Brak lekcji");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/schools/{schoolId}/lessons")
    ResponseEntity<List<Lekcja>> getLessonsFromSchool(@PathVariable("schoolId") int schoolId){
        log.info("Szukam listy lekcji w szkole");
        Szkola szkola = szkolaService.getSzkolaById(schoolId);
        if(szkola == null){
            return ResponseEntity.notFound().build();
        }else {
            List<Lekcja> lessons = szkola.getLekcje();
            return ResponseEntity.ok(lessons);
        }
    }

    @PostMapping("/lessons")
    ResponseEntity<?> addNewLesson(@RequestBody LessonDTO lessonDTO){
        log.info("Dodaje nowy przedmiot: {}", lessonDTO);
        Lekcja lesson = new Lekcja();
        lesson.setNazwa_przedmiotu(lessonDTO.getSubjectName());
        lesson.setLiczba_godzin(lessonDTO.getECTS());
        lesson.setNauczyciel(lekcjaService.getNauById(lessonDTO.getTeacherId()));

        lesson = lekcjaService.addLekcja(lesson);
        log.info("Przedmiot dodany: {}", lesson);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .path("/" + lesson.getId())
                        .build()
                        .toUri())
                .body(lesson);
    }
}
