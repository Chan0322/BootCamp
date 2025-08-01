package com.msa.posts.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/posts")
    public Post[] posts() {
        Post[] posts = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts", Post[].class);
        return posts;
    }

    @GetMapping("/posts/{id}")
    public Map post(@PathVariable String id) {
        Post post = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+id, Post.class);
        // postId에 comments 정보를 같이 리턴하는 구조...
        Comment[] comments = restTemplate.getForObject(
                "http://localhost:8082/comments/"+id, Comment[].class);
        Map result = new HashMap();
        result.put("post", post);
        result.put("comments", comments);

        return result;
    }
}