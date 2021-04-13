package sk.ness.interview.dao;

import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.Comment;

import java.util.List;

public interface CommentDAO {

    /**
     * Returns all available {@link Comment}s with provided {@link Article} ID
     */
    List<Comment> findByArticleID(Integer articleId);

    /**
     * Returns all available {@link Comment}s
     */
    List<Comment> findAll();

    void persist(Comment comment);
}
