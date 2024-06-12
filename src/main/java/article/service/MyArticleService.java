package article.service;

import article.Article;
import article.repository.MySqlArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MyArticleService implements ArticleService {
    @Override
    public ArrayList<String> getLinks(String url) {
        //HashSet dung de chua chua cac phan tu unique, nhung phan tu giong nhau se de len va xoa phan tu cu di
        HashSet<String> collectLinks = new HashSet<>();
        String firstContains = "https://";
        String lastContains = ".htm";
//        ArrayList<String> collectLinksArray = null;
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href.contains(firstContains) && href.contains(lastContains)) {
                    collectLinks.add(href);
                }
            }
            System.out.println(collectLinks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(collectLinks);
    }

    @Override
    public Article getArticle(String linkArticle) {
        Document document = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Scanner scanner = new Scanner(System.in);
        try{
            document = Jsoup.connect(linkArticle).get();

            String title = document.select("h1.title-detail").text();
            String description = document.select("p.description").text();
            String content = document.select("article.fck_detail p.normal").text();
            String img = document.select("img[itemprop=contentUrl]").attr("data-src");
            String thumbnail = document.select("img[itemprop=contentUrl]").attr("data-src");
            String authorName = document.select("article.fck_detail .width-detail-photo p[style=text-align:right;] Strong").text();
            String createAt = dtf.format(now);
            String updateAt = dtf.format(now);
            String deleteAt = dtf.format(now);
//            System.out.println("enter status:");
//            int status = scanner.nextInt();

            Article article = new Article();

            article.setBaseUrl(linkArticle);
            article.setTitle(title);
            article.setDescription(description);
            article.setContent(content);
            article.setImg(img);
            article.setThumbnail(thumbnail);
            article.setCreateAt(LocalDate.parse(createAt));
            article.setCreateAt(LocalDate.parse(updateAt));
            article.setCreateAt(LocalDate.parse(deleteAt));
            article.setAuthorName(authorName);
//            article.setStatus(status);
            System.out.println(article);
            MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();

//            mySqlArticleRepository.save(article);

            return article;
        }catch (IOException e){
            e.printStackTrace();
        };
        return null;
    }
}
