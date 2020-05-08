package com.jasonvanblarcum.showcase.services;

import com.jasonvanblarcum.showcase.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
