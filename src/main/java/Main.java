import article.Application;
import article.service.MyArticleService;
import article.crawler.MyCrawlerArticles;
import article.service.VnExpressArticleService;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.generateMenu();
    }
}
