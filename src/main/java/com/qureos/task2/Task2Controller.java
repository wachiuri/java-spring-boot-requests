/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qureos.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author timot
 */
@RestController
public class Task2Controller {

    @GetMapping("/task2/{movieTitle}")
    public ArrayList<String> index(@PathVariable("movieTitle") String movieTitle) throws IOException {
        OkHttpClient client = new OkHttpClient();

        int page = 1;
        int total_pages = 1;
        ArrayList<String> movieTitles = new ArrayList<>();
        while (page <= total_pages) {
            Request request = new Request.Builder()
                    .url("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + movieTitle + "&page=" + page)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                ObjectMapper objectMapper = new ObjectMapper();
                MoviesResponse moviesResponse = objectMapper.readValue(response.body().string(), MoviesResponse.class);

                total_pages = moviesResponse.getTotal_pages();
                moviesResponse.getData()
                        .forEach((Movie movie) -> {
                            movieTitles.add(movie.Title);
                });

            }
            page++;
        }

        movieTitles.sort((String o1, String o2) -> o1.compareTo(o2));

        return movieTitles;
    }
}
