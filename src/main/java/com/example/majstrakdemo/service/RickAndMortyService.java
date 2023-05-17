package com.example.majstrakdemo.service;

import com.example.majstrakdemo.domain.Result;
import com.example.majstrakdemo.domain.RickAndMortyCharacters;

public interface RickAndMortyService {
    void save(Result result);

    void modify();
    RickAndMortyCharacters getAllCharacters();
}
