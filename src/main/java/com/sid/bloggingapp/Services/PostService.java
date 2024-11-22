package com.sid.bloggingapp.Services;

import com.sid.bloggingapp.Payloads.PostDto;
import com.sid.bloggingapp.Payloads.PostResponce;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    PostDto getPostById(Integer postId);

    PostResponce getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    PostResponce getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

    PostResponce getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);

    PostResponce searchPost(String keyword, int pageNumber, int pageSize);
}
