package ru.coursework.Planetarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.Planetarium.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
