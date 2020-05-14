package com.jasonvanblarcum.showcase.data;

import com.jasonvanblarcum.showcase.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer>{

//    List<Post> findAll();
//    List<Post> findLatest5();
//    Post findById(Long id);
//    Post create(Post post);
//    Post edit(Post post);
//    void deleteById(Long id);

}
