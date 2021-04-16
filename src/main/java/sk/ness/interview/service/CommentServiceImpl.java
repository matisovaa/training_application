package sk.ness.interview.service;

import org.springframework.stereotype.Service;
import sk.ness.interview.dao.CommentDAO;
import sk.ness.interview.domain.Comment;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDAO commentDAO;

    @Override
    public List<Comment> findAllComments() {
        return this.commentDAO.findAll();
    }

    @Override
    public void createComment(final Comment comment) {
        this.commentDAO.persist(comment);
    }

    @Override
    public List<Comment> findCommentsByArticleID(final Integer articleId) {
        return this.commentDAO.findByArticleID(articleId);
    }

}
