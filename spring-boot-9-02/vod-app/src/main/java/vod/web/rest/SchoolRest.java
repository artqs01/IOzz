package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Lekcja;
import vod.model.Szkola;
import vod.service.LekcjaService;
import vod.service.SzkolaService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class SchoolRest {

    private final SzkolaService szkolaService;
    private final LekcjaService lekcjaService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/schools")
    List<Szkola> getSchools(
            @RequestParam(value = "gadka", required = false) String gadka,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "zainteresowania", required = false) String someCookie
    ){
        log.info("Jest gadka: {}", gadka);
        log.info("Znaleziono customowo lepetyne: {}", customHeader);
        log.info("Znaleziono pysznosci: {}", someCookie);
        List<Szkola> szkolas = szkolaService.getAllSzkoly();
        log.info("{} znalezionych szkol", szkolas.size());
        szkolas.forEach(school -> log.info("{}", school));
        return szkolas;
    }

    @GetMapping("/schools/{id}")
    ResponseEntity<Szkola> getSchoolById(@PathVariable("id") int id){
        Szkola szkola = szkolaService.getSzkolaById(id);
        if(szkola != null){
            log.info("{} znaleziono szkole", szkola.getNazwa() );
            return ResponseEntity.ok(szkola);
        }else {
            log.info("Brak szkoly");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/lessons/{lessonId}/schools")
    ResponseEntity<List<Szkola>> getSchoolsWithLessons(@PathVariable("lessonId") int lessonId){
        log.info("Szukam szkoly po rodzaju lekcji");
        Lekcja lesson = lekcjaService.getLekcjaById(lessonId);
        if(lesson == null){
            return ResponseEntity.notFound().build();
        }else {
            List<Szkola> szkolas = szkolaService.getSzkolaByLekcja(lesson);
            return ResponseEntity.ok(szkolas);
        }
    }

    @PostMapping("/schools")
    ResponseEntity<?> addNewSchool(@Validated @RequestBody Szkola szkola, Errors errors, HttpServletRequest request){
        log.info("Powstaje nowa szkola...");
        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessages = errors.getAllErrors()
                    .stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessages);
        }
        szkola = szkolaService.addSzkola(szkola);
        log.info("Szkola dziala {}", szkola);
        return ResponseEntity.ok(szkola);
    }
}
