package com.example.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.models.CatalogItem;
import com.example.models.Movie;
import com.example.models.Rating;
import com.example.models.UserRating;
import com.example.services.MovieInfo;
import com.example.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingInfo;
	
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		List<CatalogItem> catalogItems = new ArrayList<>();
		
		//Response from rating data service is hardcoded now
		UserRating userRating = userRatingInfo.getUserRating(userId);
		List<Rating> ratings = userRating.getUserRating();
		
		for(Rating rating : ratings) {
			movieInfo.getCatalogItem(catalogItems, rating);
		}
		return catalogItems;
	}
}

//RestTemplate is deprecated now. We should use webClientBuilder instead (Refer webflux tutorial)
/*
 * Movie movie = webClientBuilder.build() .get()
 * .uri("http://localhost:8082/movies/"+rating.getMovieId()) .retrieve()
 * .bodyToMono(Movie.class)//async call .block();
 *///blocking the execution until async call is completed