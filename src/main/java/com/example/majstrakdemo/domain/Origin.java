
package com.example.majstrakdemo.domain;

import jakarta.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "Origin")
public class Origin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;

    @OneToOne(mappedBy = "origin")
    private Result character;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Result getCharacter() {
        return character;
    }

    public void setCharacter(Result character) {
        this.character = character;
    }
}
