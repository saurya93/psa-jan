package com.Gblogs.controller;

import com.Gblogs.entity.Comment;
import com.Gblogs.entity.Post;
import com.Gblogs.repository.CommentRepository;
import com.Gblogs.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    //addComments
    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComments(@RequestBody Comment comment,
                                                  @RequestParam long postId){
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        Comment savecomment = commentRepository.save(comment);
        return new ResponseEntity<>(savecomment,HttpStatus.CREATED);
    }
}
