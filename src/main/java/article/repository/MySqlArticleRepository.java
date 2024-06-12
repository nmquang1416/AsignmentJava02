package article.repository;

import article.Article;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/java_assignment_02";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public ArrayList<Article> findAll() {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "select * from articles where status = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String base_url = resultSet.getString("base_url");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                String img = resultSet.getString("img");
                String thumbnail = resultSet.getString("thumbnail");
                String author_name = resultSet.getString("author_name");
                LocalDate create_at = LocalDate.parse(resultSet.getString("create_at"));
                LocalDate update_at = LocalDate.parse(resultSet.getString("update_at"));
                LocalDate delete_at = LocalDate.parse(resultSet.getString("delete_at"));

                Article article = new Article();

                article.setBaseUrl(base_url);
                article.setTitle(title);
                article.setDescription(description);
                article.setContent(content);
                article.setImg(img);
                article.setThumbnail(thumbnail);
                article.setAuthorName(author_name);
                article.setCreateAt(create_at);
                article.setUpdateAt(update_at);
                article.setDeleteAt(delete_at);

                articles.add(article);
            }
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }

    @Override
    public Article findByUrl(String url) {
        Article article = null;
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "select * from articles where base_url = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);
            preparedStatement.setString(1, url);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String base_url = resultSet.getString("base_url");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                String img = resultSet.getString("img");
                String thumbnail = resultSet.getString("thumbnail");
                String author_name = resultSet.getString("author_name");
                LocalDate create_at = LocalDate.parse(resultSet.getString("create_at"));
                LocalDate update_at = LocalDate.parse(resultSet.getString("update_at"));
                LocalDate delete_at = LocalDate.parse(resultSet.getString("delete_at"));

                article.setBaseUrl(base_url);
                article.setTitle(title);
                article.setDescription(description);
                article.setContent(content);
                article.setImg(img);
                article.setThumbnail(thumbnail);
                article.setAuthorName(author_name);
                article.setCreateAt(create_at);
                article.setUpdateAt(update_at);
                article.setDeleteAt(delete_at);
            }
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Article save(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "insert into articles (base_url, title, description, content, img, thumbnail, author_name, create_at, update_at, delete_at, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);

            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getImg());
            preparedStatement.setString(6, article.getThumbnail());
            preparedStatement.setString(7, article.getAuthorName());
            preparedStatement.setString(8, String.valueOf(article.getCreateAt()));
            preparedStatement.setString(9, String.valueOf(article.getUpdateAt()));
            preparedStatement.setString(10, String.valueOf(article.getDeleteAt()));
            preparedStatement.setInt(11, article.getStatus());

            preparedStatement.execute();
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER,MYSQL_PASSWORD);
            String SQL_String = "update articles set base_url = ?, title = ?, description = ?, content = ?, img = ?, thumbnail = ?, author_name = ?, create_at = ?, update_at = ?, delete_at = ?, status = ? where base_url = ?,";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);

            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getImg());
            preparedStatement.setString(6, article.getThumbnail());
            preparedStatement.setString(7, article.getAuthorName());
            preparedStatement.setString(8, String.valueOf(article.getCreateAt()));
            preparedStatement.setString(9, String.valueOf(article.getUpdateAt()));
            preparedStatement.setString(10, String.valueOf(article.getDeleteAt()));
            preparedStatement.setInt(11, article.getStatus());
            preparedStatement.execute();
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "update articles set status = -1 where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);

            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println("success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
