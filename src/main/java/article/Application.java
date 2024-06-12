package article;

import article.repository.MySqlArticleRepository;
import article.service.MyArticleService;
import article.service.VnExpressArticleService;

import java.util.Scanner;

public class Application {
    public void generateMenu(){
        MyArticleService myArticleService = new MyArticleService();
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do{
            System.out.println("enter your choice");
            System.out.println("01. Crawl information from vnexpress.");
            System.out.println("02. Crawl information from My Source");
            System.out.println("03. Show all information");
            System.out.println("04. Exit");
            System.out.println("Your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    VnExpressArticleService vnExpressArticleService = new VnExpressArticleService();
                    vnExpressArticleService.getLinks("https://vnexpress.net/");
                    break;
                case 2:
                    System.out.println("please enter your link: ");
                    String url = scanner.nextLine();
                    myArticleService.getLinks(url);
                    break;
                case 3:
                    mySqlArticleRepository.findAll();
                    break;
                case 4:
                    System.out.println("goodbye");
                    break;
            }
            System.out.println("do you want continue?");
            System.out.println("[1]. yes");
            System.out.println("[2]. no");
            choice = scanner.nextInt();
        }while (choice != 2);


    }
}
