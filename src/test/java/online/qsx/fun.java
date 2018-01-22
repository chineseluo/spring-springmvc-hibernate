package online.qsx;

import online.qsx.project.dao.impl.HobbyDaoImpl;
import online.qsx.project.dao.impl.UserDaoImpl;
import online.qsx.project.dao.impl.WorkDaoImpl;
import online.qsx.project.model.Hobby;
import online.qsx.project.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 84825 on 2018/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-hibernate.xml"})
public class fun {
    @Autowired
    private HobbyDaoImpl hobbyDaoImpl;
    @Autowired
    private SessionFactory sessionFactory;
    @Test
    public void check(){
        Session session= sessionFactory.openSession();
        User u = (User)session.get(User.class, 1l);
        System.out.println(u);
        System.out.println(u.toStringAndHobbyAndWork());
    }
}
