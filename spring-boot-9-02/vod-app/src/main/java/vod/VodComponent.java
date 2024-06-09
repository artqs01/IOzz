package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Szkola;
import vod.service.SzkolaService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

	private final SzkolaService szkolaService;

	public VodComponent(SzkolaService service) {
		this.szkolaService = service;
		log.info("konstruktor VodComponent");
	}

	@PostConstruct
	void init(){
		log.info("inicjuje");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("args: {}", Arrays.toString(args));
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("onApplicationEvent");
		List<Szkola> szkoly = szkolaService.getAllSzkoly();
		log.info("{} znalezionych szkol", szkoly.size());
		szkoly.forEach(school -> log.info("{}", school));
	}

	@EventListener
	public void eventListener(ContextRefreshedEvent event) {
		log.info("context refreshed event");
	}
}
