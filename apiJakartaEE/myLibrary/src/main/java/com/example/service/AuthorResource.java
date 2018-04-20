package com.example.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.data.AuthorDAO;
import com.example.model.Author;

@Path("authors")
public class AuthorResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors() {
    	List<Author> authors = new AuthorDAO().getAuthors();
        return Response.ok(authors, MediaType.APPLICATION_JSON).build();
    }
}
