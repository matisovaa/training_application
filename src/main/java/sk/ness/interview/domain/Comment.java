package sk.ness.interview.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@SequenceGenerator(name = "comments_seq_store", sequenceName = "comment_seq", allocationSize = 1)
public class Comment {

    public Comment() {
        this.createdDate = new Date();
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_store")
    private Integer id;

    //@Column(name = "article_id")
    //private Integer articleId;
    @ManyToOne
    @JoinColumn(name="articles.id", nullable=false)
    private ArticleWithComments article;

    @Column(name = "author", length = 250)
    private String author;

    @Column(name = "text", length = 2000)
    private String text;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArticleWithComments getArticle() {
        return article;
    }

    public void setArticle(ArticleWithComments article) {
        this.article = article;
    }

    /*
        public Integer getArticleId() {
            return articleId;
        }

        public void setArticleId(Integer articleId) {
            this.articleId = articleId;
        }
        */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
