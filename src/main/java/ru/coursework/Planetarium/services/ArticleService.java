package ru.coursework.Planetarium.services;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coursework.Planetarium.entity.Article;
import ru.coursework.Planetarium.repositories.ArticleRepository;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    public Article getById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public void deleteArticle(long id) {
        articleRepository.delete(getById(id));
    }

}
