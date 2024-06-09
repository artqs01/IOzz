package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class Advisor {

    private final SchoolValidator schoolValidator;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(schoolValidator);
    }
}
