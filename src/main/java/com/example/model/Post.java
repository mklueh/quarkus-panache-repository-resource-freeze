package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "post")
@EqualsAndHashCode(callSuper = true, exclude = "author")
public class Post extends BaseEntity {

    @ManyToOne
    @JsonbTransient
    @JoinColumn(name = "author_id")
    Author author;

    @Column(name = "title")
    String title;

}
