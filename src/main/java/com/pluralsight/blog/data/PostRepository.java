package com.pluralsight.blog.data;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    public default List<Post> findAll() {
        return new ArrayList<>();
    }

    public static List<Post> saveAll(List<Post> posts) {
        return new ArrayList<>();
    }

    public Post save(Post post);

    public default Optional<Post> findById(Long id) {
        return null;
    }
    
    public default String findByAuthor_Lastname(String lastname) {
    	return lastname;
    }
    
    @RestResource(exported = true) 
    List<Post> findByTitleContaining(String title);

}