package online.qsx.project.service;

import online.qsx.project.model.Hobby;
import online.qsx.project.model.User;

import java.util.List;

/**
 * Created by 84825 on 2018/1/16.
 */
public interface UserServer {
    //查询所有用户
    public List<User> findAllUser();
    //查询用户的爱好
//    public String hobbyname(User user);
//    //查询用户的职业
//    public String workname(User user);

    //删除用户
    public void removeUser(User user);

    //修改密码
    public void modifyPassword(User user);

    //查询一个用户
    public User findUser(User user);

    //修改一个用户信息
    public void editUser(User user);

    //分页查询
    public List<User> findByPage(int pageNo, int pageSize);

    public int getUsersCount();

    //保存用户
    public void saveUser(User user);
}
