package com.example.zti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.zti.model.Link;
import com.example.zti.repository.LinkRepository;

/**
 * Uruchomienie aplikacji 
 * 
 * @author Piotr Witkos
 */
@SpringBootApplication
public class ZtiApplication{

//	LinkRepository linkRepository;
	public static void main(String[] args) {
		SpringApplication.run(ZtiApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) {
//		Link firstLink = new Link("https://www.google.pl/","link do google");
//		linkRepository.save(firstLink);
//		System.out.println(firstLink);
//	}
}
