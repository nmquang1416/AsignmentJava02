package article;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class MyCrawlerArticles implements CrawlerArticles{

    @Override
    public void crawlerLink(String link) {
        MyArticleService myArticleService = new MyArticleService();
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("DataBaseNote.txt", true));
            for (int i = 0; i < myArticleService.getLinks(link).size(); i++) {
                printWriter.printf("\n %d | %s |", i, myArticleService.getLinks(link).get(i));
            }
            printWriter.printf("\n-------------------------------------------");
//            System.out.println(collectLinks);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crawlerArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("DataBaseNote.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true){
                String content = bufferedReader.readLine();
                if (content ==null){
                    break;
                }
                System.out.println(content);
                String[] ArticlesSplit =  content.split("\\|");
                if (ArticlesSplit.length == 2){
                    Article article = new Article();
                    article.setTitle(ArticlesSplit[0]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
