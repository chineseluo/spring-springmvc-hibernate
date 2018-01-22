package online.qsx.project.service.impl;

import online.qsx.project.dao.impl.WorkDaoImpl;
import online.qsx.project.model.Work;
import online.qsx.project.service.WorkServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
@Service
public class WorkServerImpl implements WorkServer {
    @Autowired
    @Qualifier(value = "workDaoImpl")
    private WorkDaoImpl workDaoImpl;

    //查找所有工作信息
    public List<Work> findAllWork() {
        return workDaoImpl.findAllWorks();
    }

    @Override
    public void saveWork(String workname) {
        workDaoImpl.saveWork(workname);
    }

    @Override
    public void removeWork(Long workid) {
        workDaoImpl.removeWork(new Work(workid));
    }

    @Override
    public Work findWork(Long workid) {
        return workDaoImpl.findWork(new Work(workid));
    }

    @Override
    public void saveEdit(Work work) {
        workDaoImpl.saveEdit(work);
    }
}
