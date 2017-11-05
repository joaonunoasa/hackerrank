import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public int getCircleCount() {
        String sql = "select count(*) from Circle";
        Query query = sessionFactory.openSession().createQuery(sql);
        return ((Long) query.uniqueResult()).intValue();
    }
}