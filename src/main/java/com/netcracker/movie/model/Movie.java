package com.netcracker.movie.model;

import lombok.Data;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Movie implements Identifiable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
        this.name = "Undefined";
    }
}
