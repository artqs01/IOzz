package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Szkola;
import vod.service.SzkolaService;

@Component
@RequiredArgsConstructor
public class SchoolValidator implements Validator {

    private final SzkolaService szkolaService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Szkola.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Szkola validatedSzkola = (Szkola) target;

        boolean duplicated = szkolaService.getAllSzkoly().stream()
                .anyMatch(school -> school.getNazwa().equalsIgnoreCase(validatedSzkola.getNazwa()));
        if(duplicated){
            errors.rejectValue("name", "school.name.duplicated");
        }
    }
}
