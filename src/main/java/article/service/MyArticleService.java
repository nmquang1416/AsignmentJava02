package article.service;

import article.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MyArticleService implements ArticleService {
    @Override
    public ArrayList<String> getLinks(String url) {
        //HashSet dung de chua chua cac phan tu unique, nhung phan tu giong nhau se de len va xoa phan tu cu di
        HashSet<String> collectLinks = new HashSet<>();
        String firstContains = "https://vnexpress.net/";
        String lastContains = ".html";
        ArrayList<String> collectLinksArray = null;
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href.contains(firstContains) && href.contains(lastContains)) {
                    collectLinks.add(href);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(collectLinks);
    }

    @Override
    public Article getArticle(String linkArticle) {
        Document document = null;
        ArrayList<String> imgUrls = new ArrayList<>();
        try{
            document = Jsoup.connect(linkArticle).get();
            String baseUrl = document.title();
            String title = document.select("h1.title-detail").text();
            String description = document.select("p.description").text();
            String desc_cation = document.select(".desc_cation p").text();
            String image = document.select("img[itemprop=contentUrl]").attr("data-src");
            String authorName = document.select("article.fck_detail .width-detail-photo p[style=text-align:right;] Strong").text();


            Article article = new Article();

            article.setTitle(title);
            article.setBaseUrl(baseUrl);
            article.setDescription(description);
            System.out.println(image);
            article.setAuthorName(authorName);
            System.out.println("Article: " + article);

            return article;
        }catch (IOException e){
            e.printStackTrace();
        };
        return null;
    }
}
