package article.repository;

import article.Article;

import java.util.ArrayList;

public interface ArticleRepository {
    ArrayList<Article> findAll();
    Article findByUrl(String url);
    Article save(Article article);
    Article update(Article article);
    void delete(long id);
}
