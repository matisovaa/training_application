package sk.ness.interview.dao;

import java.util.List;

import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.ArticleWithComments;

public interface ArticleDAO {

    /**
     * Returns {@link Article} with provided ID
     */
    Article findByID(Integer articleId);

    /**
     * Returns {@link ArticleWithComments} with provided ID
     */
    ArticleWithComments findByIDDetail(Integer articleId);

    /**
     * Returns all available {@link Article}s
     */
    List<Article> findAll();

    /**
     * Persists {@link Article} into the DB
     */
    void persist(Article article);

    /**
     * Returns {@link Article}s where author, title or text contains the searchText
     */
    List<Article> searchArticle(String searchText);
}
