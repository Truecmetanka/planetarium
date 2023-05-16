package ru.coursework.Planetarium.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.security.AuthenticatedPersonService;
import ru.coursework.Planetarium.services.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final AuthenticatedPersonService authenticatedPersonService;
    private final PersonService personService;

    @GetMapping("/favorites")
    public List<Article> getFavorites() {
        return authenticatedPersonService.getAuthenticatedPerson().getFavorites();
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return personService.findAll();
    }
}
