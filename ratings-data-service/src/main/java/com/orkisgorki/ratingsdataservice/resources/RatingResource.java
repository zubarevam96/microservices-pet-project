package com.orkisgorki.ratingsdataservice.resources;

import com.orkisgorki.ratingsdataservice.models.Rating;
import com.orkisgorki.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 1);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 1),
                new Rating("5678", 2),
                new Rating("90", 3)
        );
        UserRating userRating = new UserRating(ratings);

        return userRating;
    }
}
