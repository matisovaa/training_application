package sk.ness.interview.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sk.ness.interview.domain.Comment;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO for {@link Comment} related DB operations
 */
@Repository
public class CommentHibernateDAO implements CommentDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> findByArticleID(final Integer articleId) {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comments WHERE article_id=:articleId").addEntity(Comment.class).setInteger("articleId", articleId).list();
    }

    @Override
    public List<Comment> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comments").addEntity(Comment.class).list();

    }

    @Override
    public void persist(final Comment comment) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }
}
