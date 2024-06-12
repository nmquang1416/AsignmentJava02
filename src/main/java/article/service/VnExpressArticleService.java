package article.service;

import article.Article;

import java.util.ArrayList;

public class VnExpressArticleService implements ArticleService {
     MyArticleService myArticleService = new MyArticleService();
    @Override
    public ArrayList<String> getLinks(String url) {
        return myArticleService.getLinks(url);
    }

    @Override
    public Article getArticle(String link) {
        return myArticleService.getArticle(link);
    }
}
