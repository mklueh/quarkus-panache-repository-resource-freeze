package com.example;

import com.example.model.Author;
import com.example.model.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.jboss.logging.annotations.Pos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/post")
public class PostController {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    PostRepository postRepository;


    @GET
    @Path("/create")
    @Transactional
    public Response create(@QueryParam("title")String title,@QueryParam("author")Long authorId){


        Author author = authorRepository.findById(authorId);

        if(author==null){
            return Response.serverError().build();
        }

        Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);

        postRepository.persist(post);

        return Response.accepted(post).build();
    }
}
