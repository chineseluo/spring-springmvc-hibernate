package online.qsx.project.dao.impl;

import online.qsx.project.dao.BaseDao;
import online.qsx.project.model.Hobby;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 84825 on 2018/1/17.
 */
@Repository(value = "hobbyDaoImpl")
public class HobbyDaoImpl {
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private SessionFactory sessionFactory;

    //查找所有爱好
    public List<Hobby> findByHobby() {
        return (List<Hobby>) baseDao.getHibernateTemplate().find("from Hobby");
    }

    //保存爱好
    public void saveHobby(String hobbyname) {
        baseDao.getHibernateTemplate().save(new Hobby(hobbyname));
    }

    //删除爱好
    @Transactional
    public void removeHobby(Hobby hobby) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(hobby);
        System.out.println("删除成功");
    }

    //查询一个爱好
    @Transactional
    public Hobby findHobby(Hobby hobby) {
        Session session = sessionFactory.getCurrentSession();
        //Query query=  session.createQuery("from Hobby h where h.id="+hobby.getId());
        Hobby hobby1 = (Hobby) session.get(Hobby.class, hobby.getId());
        return hobby1;
    }

    //保存查询修改的对象
    @Transactional
    public void saveEdit(Hobby hobby) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(hobby);
    }
}
