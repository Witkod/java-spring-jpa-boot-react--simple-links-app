package com.example.zti;
import com.example.zti.repository.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.zti.model.*;

@Component
public class RunAtStart {
	private final LinkRepository linkRepository;
	
	@Autowired
	public RunAtStart(LinkRepository linkRepository) {
		super();
		this.linkRepository = linkRepository;
	}
	
	@PostConstruct
	public void runAtStart() {
		Link firstLink = new Link("https://www.google.pl/","link do google");
		linkRepository.save(firstLink);
		System.out.println(firstLink);
	}
}
