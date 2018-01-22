package online.qsx.project.service;

import online.qsx.project.model.Hobby;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
public interface HobbyServer {
    public List<Hobby> findByHobby();

    public void saveHobby(String hobbyname);

    //删除爱好
    public void removeHobby(Long hobbyId);

    //查询一个爱好
    public Hobby findHobby(Long hobbyId);

    //修改一个爱好
    public void saveEdit(Hobby hobby);
}
