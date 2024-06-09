package article;

import java.util.ArrayList;

public class VnExpressArticleService implements ArticleService {
     MyArticleService myArticleService = new MyArticleService();
    @Override
    public ArrayList<String> getLinks(String url) {
        return myArticleService.getLinks("https://vnexpress.net/");
    }

    @Override
    public Article getArticle(String link) {
        return myArticleService.getArticle("https://vnexpress.net/tuyen-viet-nam-den-iraq-sau-13-gio-di-chuyen-4756047.html");
    }
}
