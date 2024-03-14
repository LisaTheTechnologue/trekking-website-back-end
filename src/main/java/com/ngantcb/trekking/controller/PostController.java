package com.ngantcb.trekking.controller;

import com.ngantcb.trekking.dto.PostDto;
import com.ngantcb.trekking.entity.Post;
import com.ngantcb.trekking.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("create")
    public ResponseEntity<Post> createPost (@RequestBody PostDto postDto){
        Post post = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts (){
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
