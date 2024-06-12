package article;

import java.time.LocalDate;
import java.util.Arrays;

public class Article {
    private String baseUrl;
    private String title;
    private String description;
    private String content;
    private String img;
    private String thumbnail;
    private String authorName;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate deleteAt;
    private int status; //1. active | 0. pending | -1. deleted

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                ", \nbaseUrl='" + baseUrl + '\'' +
                ", \ntitle='" + title + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \ncontent='" + content + '\'' +
                ", \nimg=" + img +
                ", \nthumbnail='" + thumbnail + '\'' +
                ", \nauthorName='" + authorName + '\'' +
                ", \ncreateAt=" + createAt +
                ", \nupdateAt=" + updateAt +
                ", \ndeleteAt=" + deleteAt +
                ", \nstatus=" + status +
                '}';
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDate deleteAt) {
        this.deleteAt = deleteAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
