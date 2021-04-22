package sk.ness.interview.service;

import java.util.List;

import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.ArticleWithComments;

/**
 * Service should be used as a gateway to {@link Article} world and handle all article related manipulation.
 *
 * @author michal.kmetka
 */
public interface ArticleService {

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
     * Creates new {@link Article}
     */
    void createArticle(Article article);

    /**
     * Creates new {@link Article}s by ingesting all articles from json
     */
    void ingestArticles(String jsonArticles);

    /**
     * Returns {@link Article}s where author, title or text contains the searchText
     */
    List<Article> searchArticle(String searchText);
}
