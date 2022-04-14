/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qureos.task1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author timot
 */
@RestController
public class Task1Controller {
    
    @GetMapping("/task1/{input}")
    public String task1(@PathVariable("input") String input){
        String[] output = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            output[i] = input.charAt(i) + "-" + (i + 1);
        }
        return String.join(",", output);
    }    
}
