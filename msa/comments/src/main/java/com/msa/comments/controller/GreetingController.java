package com.msa.comments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/comments/{postId}")
    public Post[] posts(@PathVariable String postId) {
        Post[] posts = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+postId+"/comments", Post[].class);
        return posts;
    }
}