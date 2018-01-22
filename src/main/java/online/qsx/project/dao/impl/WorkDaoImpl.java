package online.qsx.project.dao.impl;


import online.qsx.project.dao.BaseDao;
import online.qsx.project.model.Hobby;
import online.qsx.project.model.Work;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * Created by 84825 on 2018/1/16.
 */
@Repository(value = "workDaoImpl")
public class WorkDaoImpl {
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private SessionFactory sessionFactory;

    //查找所有职业信息
    @Transactional
    public List<Work> findAllWorks() {
        return (List<Work>) baseDao.getHibernateTemplate().find("from Work");
    }

    //保存职业信息
    @Transactional
    public void saveWork(String workname) {
        baseDao.getHibernateTemplate().save(new Work(workname));
    }

    @Transactional
    public void removeWork(Work work) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(work);
        System.out.println("删除成功");
    }

    //查询一个职业
    @Transactional
    public Work findWork(Work work) {
        Session session = sessionFactory.getCurrentSession();
        //Query query=  session.createQuery("from Hobby h where h.id="+hobby.getId());
        Work work1 = (Work) session.get(Work.class, work.getId());
        return work1;
    }

    //保存查询修改的对象
    @Transactional
    public void saveEdit(Work work) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(work);
    }
}
