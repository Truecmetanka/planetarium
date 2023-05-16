package ru.coursework.Planetarium.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.security.PersonDetails;
import ru.coursework.Planetarium.services.ArticleService;
import ru.coursework.Planetarium.services.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final PersonService personService;

    @PostMapping("/add")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @GetMapping()
    public List<Article> getArticles() {
        return articleService.getAll();
    }

    @PostMapping("/add_to_fav/{id}")
    public void addArticleToFav(@PathVariable("id") int id) {
        System.out.println(articleService.getById(id));
        System.out.println("hui");
        personService.addArticleToFavorites(articleService.getById(id));
    }

}
