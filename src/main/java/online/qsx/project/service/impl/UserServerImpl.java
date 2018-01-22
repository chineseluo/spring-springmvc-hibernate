package online.qsx.project.service.impl;

import online.qsx.project.dao.impl.UserDaoImpl;
import online.qsx.project.model.User;
import online.qsx.project.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public List<User> findAllUser() {
        return userDaoImpl.findByUsers();
    }

    @Override
    public void removeUser(User user) {
        userDaoImpl.removeUser(user);
    }

    @Override
    public void modifyPassword(User user) {
        userDaoImpl.modifyPassword(user);
    }

    //查询一个用户
    @Override
    public User findUser(User user) {
        return userDaoImpl.findUser(user);
    }

    //修改一个用户信息
    @Override
    public void editUser(User user) {
        userDaoImpl.editUser(user);
    }

    @Override
    public List<User> findByPage(int pageNo, int pageSize) {
        return userDaoImpl.pageByData(pageNo, pageSize);
    }

    //分页查询
    @Override
    public int getUsersCount() {
        return userDaoImpl.getUsersCount();
    }

    @Override
    public void saveUser(User user) {
        userDaoImpl.saveUser(user);
    }
}
