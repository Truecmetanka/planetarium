package ru.coursework.Planetarium.controllers;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.security.AuthenticatedPersonService;
import ru.coursework.Planetarium.services.ArticleService;
import ru.coursework.Planetarium.services.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final PersonService personService;
    private final AuthenticatedPersonService authenticatedPersonService;

    @PostMapping("/add")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @PostMapping("/del/{id}")
    public void delArticle(@PathVariable("id") int id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/all")
    public List<Article> getArticles() {
        return articleService.getAll();
    }

    @PostMapping("/add_to_fav/{id}")
    public void addArticleToFav(@PathVariable("id") int id) {
        personService.addArticleToFavorites(articleService.getById(id));
    }

    /**
     * POST - "/del_from_fav/{id}"
     * удаление статьи из избранного
     *
     * @param id
     */

    @PostMapping("/del_from_fav/{id}")
    public void delArticleFromFav(@PathVariable("id") int id) {
        personService.delArticleFromFavorites(articleService.getById(id),
                authenticatedPersonService.getAuthenticatedPerson());
    }

}
