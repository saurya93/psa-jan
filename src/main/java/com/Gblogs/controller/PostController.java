package com.Gblogs.controller;

import com.Gblogs.entity.Post;
import com.Gblogs.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Posts")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //add post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post savedpost = postRepository.save(post);
    return new ResponseEntity<>(savedpost, HttpStatus.CREATED);
    }

}
