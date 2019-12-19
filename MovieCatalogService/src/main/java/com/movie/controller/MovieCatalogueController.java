package com.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.model.CatalogueItems;
import com.movie.model.Movie;
import com.movie.model.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogueItems> getCatalogue(@PathVariable("userId") String userId) {
 
		//List<Rating> ratings = Arrays.asList(new Rating("1234", 3), new Rating("5678", 4));
		UserRating ratings = restTemplate.getForObject("http://rating-service/rating/users/"+userId, UserRating.class);
		// Using WebClient
//		return ratings.stream().map(rating -> {
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();
//			return new CatalogueItems(movie.getName(), "movie desc", rating.getRating());
//		}).collect(Collectors.toList());

		// Using RestTemplate 
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOVIEINFOSERVICE/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogueItems(movie.getName(), "movie desc", rating.getRating());
		}).collect(Collectors.toList());

		// return Collections.singletonList(new CatalogueItems("testA", "movie1", 4));
	}
}