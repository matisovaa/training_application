package sk.ness.interview.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
@SequenceGenerator(name = "articles_seq_store", sequenceName = "article_seq", allocationSize = 1)
public class ArticleWithComments extends Article {

    public ArticleWithComments() {
    }

    public ArticleWithComments(Article article, List<Comment> comments) {
        super();
        this.setId(article.getId());
        this.setTitle(article.getTitle());
        this.setText(article.getText());
        this.setAuthor(article.getAuthor());
        this.setCreateTimestamp(article.getCreateTimestamp());
        this.setArticleComments(comments);
    }

    @OneToMany(mappedBy="article")
    private List<Comment> articleComments = new ArrayList<Comment>(0);

    public List<Comment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(List<Comment> articleComments) {
        this.articleComments = articleComments;
    }
}
