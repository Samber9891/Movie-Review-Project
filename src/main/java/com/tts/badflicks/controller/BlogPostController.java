package com.tts.badflicks.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tts.badflicks.model.BlogPost;
import com.tts.badflicks.repositories.BlogPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {
    
// brings in the blogpostrepository so that CRUD can be used in methods
    @Autowired
    BlogPostRepository blogPostRepository;

// creates the list of every blogpost, remember! posts with a 's' is an array list of blogpost
    private List<BlogPost> posts = new ArrayList<>(); 


    // used for index method, set to return the index.html template
    @GetMapping(value = "/")
    public String index(BlogPost blogPost, Model model) {
        // along with adding Model model, this allows the index page to access the arraylist of blogposts
        posts.removeAll(posts); 
        for (BlogPost post : blogPostRepository.findAll()) {
            posts.add(post); 
        }
        model.addAttribute("posts", posts); 
        return "index"; 
       
        }

        // method used to get to the new.html page
        @GetMapping(value = "/blogpost/new")
        public String newBlog (BlogPost blogPost) {
        return "new";
        }

        private BlogPost blogPost; 

        // takes the data entered in the create a blog form and adds it to the database
        @PostMapping(value = "/blogpost")
        public String addNewBlogPost(BlogPost blogPost, Model model) {

            blogPostRepository.save(blogPost); 
            model.addAttribute("title", blogPost.getTitle());
	        model.addAttribute("genre", blogPost.getGenre());
            model.addAttribute("blogEntry", blogPost.getBlogEntry());
            model.addAttribute("imageUrl", blogPost.getImageUrl());
	        return "result";
        }

        @RequestMapping(value = "/blogpost/delete/{id}")
        public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
            blogPostRepository.deleteById(id);
            return "delete";
                }   

              
	@RequestMapping(value = "/blogpost/edit/{id}")
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            model.addAttribute("blogPost", actualPost);
        }
        return "edit";
    }

    @RequestMapping(value = "/blogpost/update/{id}")
    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            actualPost.setTitle(blogPost.getTitle());
            actualPost.setGenre(blogPost.getGenre());
            actualPost.setBlogEntry(blogPost.getBlogEntry());
            actualPost.setImageUrl(blogPost.getImageUrl());
            blogPostRepository.save(actualPost);
            model.addAttribute("blogPost", actualPost);
        }
 
        return "result";
    }
}
