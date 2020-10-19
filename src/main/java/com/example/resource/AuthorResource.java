package com.example.resource;

import com.example.model.Author;
import com.example.repository.AuthorRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true, path = "author")
public interface AuthorResource extends PanacheRepositoryResource<AuthorRepository, Author, Long> {
}
