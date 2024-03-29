package com.movieinfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId")String movieId) {
		return new Movie(movieId,"test name");
	}
	
}
