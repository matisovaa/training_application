package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.ArticleWithComments;

/**
 * DAO for {@link Article} related DB operations
 *
 * @author michal.kmetka
 */
@Repository
public class ArticleHibernateDAO implements ArticleDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Article findByID(final Integer articleId) {
        return (Article) this.sessionFactory.getCurrentSession().get(Article.class, articleId);
    }

    @Override
    public ArticleWithComments findByIDDetail(Integer articleId) {
        return (ArticleWithComments) this.sessionFactory.getCurrentSession().get(ArticleWithComments.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from articles").addEntity(Article.class).list();
    }

    @Override
    public void persist(final Article article) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(article);
    }

    @Override
    public List<Article> searchArticle(final String searchText) {
        String s = "select * from articles WHERE author LIKE :searchString or title LIKE :searchString or text LIKE :searchString";
        return this.sessionFactory.getCurrentSession().createSQLQuery(s).addEntity(Article.class).setString("searchString", "%" + searchText + "%").list();
    }
}
