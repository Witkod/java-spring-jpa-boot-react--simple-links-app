package com.example.zti.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.zti.model.Link;

/**
 * Interjejs odpowiadający za dostęp do tabeli 'Link'
 * 
 * @author Piotr Witkos
 * @See CrudRepository
 */
public interface LinkRepository extends CrudRepository <Link, Long>{
	//@Query(value = "Select l.url, l.description from Link l")
	/**
	 * Wyszukuje stronę w bazie przy pomocy adresu url
	 * 
	 * @param url
	 * 			adres strony internetowej
	 * @return Klasa Link reprezentujaca szukany adres
	 */
	Link findFirstByUrl(String url);
}
