package com.orkisgorki.moviecatalogservice.resources;

import com.orkisgorki.moviecatalogservice.models.CatalogItem;
import com.orkisgorki.moviecatalogservice.models.Movie;
import com.orkisgorki.moviecatalogservice.models.Rating;
import com.orkisgorki.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String usertId) {



        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/s", UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/asdf", Movie.class);

                    return new CatalogItem(movie.getName(), "someDescription", rating.getRating());
                })
                .collect(Collectors.toList());

        // For each movie ID, call movie info service and got details

        //put them all together

    }
    /*
    Movie movie = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8091/movies/" + rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block();

     */
}
