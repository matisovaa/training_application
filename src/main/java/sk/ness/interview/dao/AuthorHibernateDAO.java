package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;

/**
 * DAO for {@link Author} related DB operations
 *
 * @author michal.kmetka
 */
@Repository
public class AuthorHibernateDAO implements AuthorDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select distinct a.author as name from articles a ")
                .addScalar("name", StringType.INSTANCE)
                .setResultTransformer(new AliasToBeanResultTransformer(Author.class)).list();
    }

    @Override
    public List<AuthorStats> getAllAuthorStats() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("SELECT a.author AS authorName, COUNT(*) AS articleCount FROM articles a GROUP BY author;")
                .addScalar("authorName", StringType.INSTANCE)
                .addScalar("articleCount", IntegerType.INSTANCE)
                .setResultTransformer(new AliasToBeanResultTransformer(AuthorStats.class)).list();
    }

}
