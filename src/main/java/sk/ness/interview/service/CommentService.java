package sk.ness.interview.service;

import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.Comment;

import java.util.List;

/**
 * Service should be used as a gateway to {@link Comment} world and handle all comment related manipulation.
 */
public interface CommentService {

    /**
     * Returns all available {@link Comment}s
     */
    List<Comment> findAllComments();

    /**
     * Creates new {@link Comment}
     */
    void createComment(Comment comment);

    /**
     * Returns all available {@link Comment}s with provided {@link Article} ID
     */
    List<Comment> findCommentsByArticleID(Integer articleId);
}
