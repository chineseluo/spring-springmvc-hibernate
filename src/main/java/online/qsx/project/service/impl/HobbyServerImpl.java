package online.qsx.project.service.impl;

import online.qsx.project.dao.impl.HobbyDaoImpl;
import online.qsx.project.model.Hobby;
import online.qsx.project.service.HobbyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
@Service
public class HobbyServerImpl implements HobbyServer {

    @Autowired
    @Qualifier(value = "hobbyDaoImpl")
    private HobbyDaoImpl hobbyDaoImpl;

    //查询所有爱好信息
    public List<Hobby> findByHobby() {
        return hobbyDaoImpl.findByHobby();
    }

    //保存爱好
    public void saveHobby(String hobbyname) {
        hobbyDaoImpl.saveHobby(hobbyname);
    }
    //删除爱好

    @Override
    public void removeHobby(Long hobbyId) {
        hobbyDaoImpl.removeHobby(new Hobby(hobbyId));
    }

    @Override
    public Hobby findHobby(Long hobbyId) {
        return hobbyDaoImpl.findHobby(new Hobby(hobbyId));
    }
    //保存编辑的爱好

    @Override
    public void saveEdit(Hobby hobby) {
        hobbyDaoImpl.saveEdit(hobby);
    }
}
