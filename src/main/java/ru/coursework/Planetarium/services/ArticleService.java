package ru.coursework.Planetarium.services;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.repositories.ArticleRepository;
import ru.coursework.Planetarium.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final PersonService personService;
    private final PersonRepository personRepository;

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article getById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public void deleteArticle(long id) {
        for (Person p : personService.findAll()) {
            personService.delArticleFromFavorites(getById(id), p);
        }
        articleRepository.deleteById(id);
    }

}
