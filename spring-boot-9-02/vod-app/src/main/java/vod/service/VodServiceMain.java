package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Szkola;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Znalezienie szkol");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");

        SzkolaService service1 = context.getBean(SzkolaService.class);
        SzkolaService service2 = context.getBean(SzkolaService.class);

        List<Szkola> szkoly = service1.getAllSzkoly();
        System.out.println(szkoly.size() + " szkoly:");
        szkoly.forEach(System.out::println);
    }
}
