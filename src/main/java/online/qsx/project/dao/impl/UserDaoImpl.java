package online.qsx.project.dao.impl;

import online.qsx.project.dao.BaseDao;
import online.qsx.project.model.User;
import online.qsx.project.model.Work;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 84825 on 2018/1/17.
 */
@Repository(value = "userDaoImpl")
public class UserDaoImpl {
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findByUsers() {
        return (List<User>) baseDao.getHibernateTemplate().find("from User");
    }

    //查询用户的爱好
//    public String findHobby(User user){
//        //System.out.println(baseDao.getHibernateTemplate().find("from User"));
//        //System.out.println(baseDao.getHibernateTemplate().find("select u.hId from User u where u.id="+user.getId()));
//        return baseDao.getHibernateTemplate().find("select h.hobbyname from Hobby h where h.id= (select hId from User u where u.id="+user.getId()+")").toString();
//    }
//    //查询用户的职业
//    public String findWork(User user){
//        return baseDao.getHibernateTemplate().find("select w.workname from Work w where w.id= (select wId from User u where u.id="+user.getId()+")").toString();
//
//    }
    //删除用户
    public void removeUser(User user) {
        baseDao.getHibernateTemplate().delete(user);
    }

    //修改用户密码
    public void modifyPassword(User user) {
        baseDao.getHibernateTemplate().update(user);
    }

    //查询单个用户
    @Transactional
    public User findUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        User user1 = (User) session.get(User.class, user.getId());
        return user1;
    }

    //修改一个用户信息
    public void editUser(User user) {
        baseDao.getHibernateTemplate().saveOrUpdate(user);
    }

    //查询学生的数量，为分页提供数据总量
    public int getUsersCount() {
        Session session = sessionFactory.getCurrentSession();
        int count = Integer.parseInt(session.createQuery("select count(*) from User").list().get(0).toString());
        return count;
    }

    //分页查询
    public List<User> pageByData(int pageNo, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        //设定从哪一行开始
        query.setFirstResult((pageNo - 1) * pageSize);
        //设定每页显示几行数据
        query.setMaxResults(pageSize);
        return query.list();
    }

    //保存用户
    public void saveUser(User user) {
        baseDao.getHibernateTemplate().save(user);
    }
}
