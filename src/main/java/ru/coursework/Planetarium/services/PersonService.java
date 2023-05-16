package ru.coursework.Planetarium.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.repositories.PersonRepository;
import ru.coursework.Planetarium.security.AuthenticatedPersonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final AuthenticatedPersonService authenticatedPersonService;

    public void addArticleToFavorites(Article article) {
        Person personToAddFav = authenticatedPersonService.getAuthenticatedPerson();
        personToAddFav.getFavorites().add(article);
        personRepository.save(personToAddFav);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
