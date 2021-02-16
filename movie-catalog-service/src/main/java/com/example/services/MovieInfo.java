package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.models.CatalogItem;
import com.example.models.Movie;
import com.example.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public void getCatalogItem(List<CatalogItem> catalogItems, Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		catalogItems.add(new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating()));
	}
	
	//Fallback method will not be called if it's called by another method internally
	public void getFallbackCatalogItem(List<CatalogItem> catalogItems, Rating rating) {
		catalogItems.add(new CatalogItem("No name available", "", rating.getRating()));
	}

}
