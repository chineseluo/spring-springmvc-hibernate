package online.qsx.project.service;

import online.qsx.project.model.Work;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
public interface WorkServer {
    public List<Work> findAllWork();

    public void saveWork(String workname);

    //删除职业
    public void removeWork(Long workid);

    //查询一个爱好
    public Work findWork(Long workid);

    //修改一个爱好
    public void saveEdit(Work work);
}

