package com.example.zti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Klasa reprezentująca tabelę Link w Bazie Danych
 * 
 * @author Piotr Witkos
 *
 */
@Entity
public class Link {
	@Id 
	@GeneratedValue 
	private Long id;
	private String url;
	private String description;
	
	
	/**
	 * @return Identyfikator strony
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return Adres url do strony internetowej
	 */	
	public String getUrl() {
		return url;
	}

	/**
	 * Przypisuje adres do strony internetowej
	 * 
	 * @param adres do strony internetowej
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return Opis strony internetowej
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Przypisuje opis strony internetowej
	 * 
	 * @param Opis strony internetowej
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Link() {
		this.url = "empty";
		this.description = "empty";
	}

	public Link(String url, String description) {
		this.url = url;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", url=" + url + ", description=" + description + "]";
	}
	
	
}
