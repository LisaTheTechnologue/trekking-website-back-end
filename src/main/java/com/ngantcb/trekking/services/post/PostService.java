package com.ngantcb.trekking.services.post;

import com.ngantcb.trekking.dto.PostDto;
import com.ngantcb.trekking.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostDto postDto);

    List<Post> getAllPosts();
}
