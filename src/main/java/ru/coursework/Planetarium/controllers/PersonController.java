package ru.coursework.Planetarium.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coursework.Planetarium.dto.ArticleDTO;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.mappers.ArticleMapper;
import ru.coursework.Planetarium.security.AuthenticatedPersonService;
import ru.coursework.Planetarium.services.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final AuthenticatedPersonService authenticatedPersonService;
    private final PersonService personService;
    private final ArticleMapper articleMapper = ArticleMapper.INSTANCE;

    @GetMapping("/favorites")
    public List<ArticleDTO> getFavorites() {
        return authenticatedPersonService.getAuthenticatedPerson().getFavorites()
                .stream().map(articleMapper::converArticleToArticleDTO).collect(Collectors.toList());
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return personService.findAll();
    }
}
