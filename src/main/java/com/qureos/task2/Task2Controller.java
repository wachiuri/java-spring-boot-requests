/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qureos.task2;

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
    public String index(@PathVariable("movieTitle") String movieTitle){
        
    }
}
