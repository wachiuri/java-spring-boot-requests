/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qureos.task2;

import java.io.IOException;
import javax.security.auth.message.callback.PrivateKeyCallback;
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
    public String index(@PathVariable("movieTitle") String movieTitle) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
        catch(IOException ex){
            return "Could not reach hackerrank";
        }
    }
}
