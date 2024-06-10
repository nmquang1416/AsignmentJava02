import article.service.MyArticleService;
import article.crawler.MyCrawlerArticles;

public class Main {
    public static void main(String[] args) {
        MyArticleService myArticleService = new MyArticleService();
        MyCrawlerArticles myCrawlerArticles = new MyCrawlerArticles();

        myCrawlerArticles.crawlerArticles();

//        myArticleService.getArticle("https://vnexpress.net/hai-phong-quang-ninh-ngap-nang-sau-mua-lon-4756176.html");
//        myArticleService.getLinks("https://vnexpress.net/");
//        myCrawlerArticles.crawlerLink("https://vnexpress.net/");
//        myArticleService.getLinks("https://vnexpress.net/hlv-kim-sang-sik-viet-nam-den-iraq-de-chien-thang-4756155.html");
    }
}
