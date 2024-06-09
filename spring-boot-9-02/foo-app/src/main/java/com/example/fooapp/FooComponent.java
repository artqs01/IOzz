package com.example.fooapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FooComponent {
	public FooComponent(String text) {
		log.info("Contructing component");
	}
}
