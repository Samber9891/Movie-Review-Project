package com.tts.badflicks.repositories;

import com.tts.badflicks.model.BlogPost;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    
}
