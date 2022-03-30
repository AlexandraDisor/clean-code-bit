package com.endava.app.mocks;

import java.util.Random;

import com.endava.app.entity.Movie;
import com.endava.app.entity.PriceCode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieMock {

    public static final String MOVIE_REGULAR = "Snatch";
    public static final String MOVIE_NEW_RELEASE = "Fargo";

    public static final int MOVIE_REGULAR_COPIES = 10;
    public static final int MOVIE_NEW_RELEASE_COPIES = 2;

    private static Random rand = new Random();

    public static Movie getMovie(String title, int copies, int priceCode) {
        return Movie.builder()
                .id(rand.nextInt(100) )
                .title(title)
                .copies(copies)
                .priceCode(PriceCode.builder().id(priceCode).build())
                .build();
    }
}
