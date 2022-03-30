package com.endava.app.mocks;

import java.time.LocalDateTime;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.endava.app.entity.Movie;
import com.endava.app.entity.Rental;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RentalMock {

    private static Random rand = new Random();


 public static Rental getRental(int daysRented, Movie movie) {
     return Rental.builder()
             .id(rand.nextInt(100) )
             .rentalDate(LocalDateTime.now())
             .daysRented(daysRented)
             .movie(movie)
             .build();
 }

}
