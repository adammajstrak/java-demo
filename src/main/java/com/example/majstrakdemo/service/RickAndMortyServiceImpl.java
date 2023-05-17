package com.example.majstrakdemo.service;

import com.example.majstrakdemo.domain.Result;
import com.example.majstrakdemo.domain.RickAndMortyCharacters;
import com.example.majstrakdemo.repositories.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {
    private final RestTemplate restTemplate;
    private final ResultRepository resultRepository;

    public RickAndMortyServiceImpl(RestTemplate restTemplate, ResultRepository resultRepository) {
        this.restTemplate = restTemplate;
        this.resultRepository = resultRepository;
    }

    @Override
    public void save(Result result) {
        this.resultRepository.saveAndFlush(result);
    }

    @Override
    public void modify() {
        var r = this.resultRepository.findAll().stream().findFirst().get();
        r.setName(r.getName() + "_dupa");
        this.save(r);
    }

    @Override
    public RickAndMortyCharacters getAllCharacters() {
        var res = restTemplate.getForObject(
                "https://rickandmortyapi.com/api/character",
                RickAndMortyCharacters.class);

        return res;
    }
}
