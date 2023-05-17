package com.example.majstrakdemo.controller;
import com.example.majstrakdemo.domain.Person;
import com.example.majstrakdemo.domain.Result;
import com.example.majstrakdemo.service.RickAndMortyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final RickAndMortyService rickAndMortyService;

    public HomeController(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping("/dupa/{id}")
    @ResponseBody
    public Person index(@PathVariable(value = "id") String id) {
        Person p = new Person();
        p.name = "Adam";
        p.familyName = id;
        return p;
    }

    @GetMapping("/characters")
    @ResponseBody
    public Map<String, Long> getAllCharacters() {

        rickAndMortyService.modify();

       return rickAndMortyService
               .getAllCharacters()
               .getResults()
               .stream()
               .filter(x -> x.getName().contains("r"))
               .collect(Collectors.groupingBy(x -> x.getName(), Collectors.counting()));
    }
}
