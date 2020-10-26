package com.example.zti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zti.model.Link;
import com.example.zti.repository.LinkRepository;

/**
 * Klasa kontrolera reprezentujace API 
 * 
 * @author Piotr Witkos
 */
@RequestMapping("/")
@RestController
@CrossOrigin("*")
public class LinksController {
	@Autowired
	private LinkRepository linkRepository;

	/**
	 * zwraca wszystkie linki
	 * @return znalezione Linki
	 */
	@GetMapping(path = "/links")
	public @ResponseBody Iterable<Link> getAllLink(){
		return linkRepository.findAll();
	}
	
	/**
	 * Znajduje szukany link po  polu adresu
	 * @param url
	 * 			Obiekt reprezentujacy link w formacie json
	 * @return znaleziony Link
	 */
	@GetMapping(path = "/link/{url}")
	public Link getLink(@PathVariable String url){
		return linkRepository.findFirstByUrl(url);
	}
	
	/**
	 * Dodaje nowy link
	 * @param link
	 * 			Obiekt reprezentujacy link w formacie json
	 * @return void
	 */
	@PostMapping(path = "/addLink")
	public void createLink(@RequestBody Link link){
		Link createdLink = linkRepository.save(link);
	}
	
	/**
	 * Usuwa stronę z bazy danych  
	 * @param id
	 * 			Identyfikator strony w bazie
	 */
	@DeleteMapping("/deleteLink/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
//		Link link = linkRepository.findFirstByUrl(url);
		linkRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	
}
