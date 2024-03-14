package com.ngantcb.trekking.services.post;

import com.ngantcb.trekking.dto.PostDto;
import com.ngantcb.trekking.entity.Post;
import com.ngantcb.trekking.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post createPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        return postRepository.save(post);
    }
    @Override
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
