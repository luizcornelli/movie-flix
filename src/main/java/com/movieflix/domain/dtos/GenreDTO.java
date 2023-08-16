package com.movieflix.domain.dtos;



import com.movieflix.domain.Genre;

import java.io.Serializable;

public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    public GenreDTO(){
    }

    public GenreDTO(Genre entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
