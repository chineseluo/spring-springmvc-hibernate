package online.qsx.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.qsx.project.model.Manager;
import online.qsx.project.model.Page;
import online.qsx.project.model.User;
import online.qsx.project.service.UserServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by 84825 on 2018/1/16.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserServer userServer;

    @Autowired
    private Page page;
    private List<User> users;
    //从那一也开始，默认从首页开始查询
    private int pageNo;
    //每页含有的数据量，默认查询数据量为3
    private int pageSize;
    //总页数
    private int totalPage;
    private int pageCount;

    /**
     * 简单登陆验证
     *
     * @param manager
     * @return
     */
    @RequestMapping(value = "check")
    public String test(Manager manager) {
        if ("jack".equals(manager.getName()) && "123456".equals(manager.getPassword())) {
            return "manage";
        }
        return "loginAgain";
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @PostMapping(value = "findAllUser", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAllUser() {
        System.out.println("开始数据传输");
        JSONArray jsonArray = new JSONArray();
        for (User user : userServer.findAllUser()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            String createdate = sd.format(user.getCreatedate());
            String birthday = sdf.format(user.getBirthday());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userid", user.getId());
            jsonObject.put("username", user.getUsername());
            jsonObject.put("workbyuser", user.getWork().getWorkname());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("sex", user.getSex());
            jsonObject.put("birthday", birthday);
            jsonObject.put("userHobby", user.getHobby().getHobbyname());
            jsonObject.put("createDate", createdate);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }

    /**
     * 删除
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "removeuser", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String removeHobby(String userid) {
        System.out.println("userid:" + userid);
        userServer.removeUser(new User(Long.parseLong(userid)));
        //return findAllUser();
        return findAllUser();
    }

    /**
     * 保存修改的密码
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "modifypassword", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String editWork(@ModelAttribute User user) {
        User user1 = userServer.findUser(new User(user.getId()));
        System.out.println("user:" + user);
        user1.setPassword(user.getPassword());
        System.out.println("USER1:" + user1);
        userServer.modifyPassword(user1);
        return "manage";
    }

    /**
     * 文件上传
     *
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("do_upload")
    @ResponseBody
    public String do_upload(MultipartFile file, HttpServletRequest request) throws Exception {
        //文件夹路径
        String url = request.getSession().getServletContext().getRealPath("/upload");
        if (!new File(url).exists()) {
            new File(url).mkdir();
        }
        System.out.println(url);
        //文件名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        System.out.println(fileName);
        org.apache.commons.io.FileUtils.copyInputStreamToFile(file.getInputStream(), new File(url + File.separator + fileName));
        return "{'url':'" + fileName + "'}";
    }


    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "saveuser", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String saveUser(@ModelAttribute User user) {
        userServer.saveUser(user);
        return "manage";
    }

    /**
     * 查询一个用户信息
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "finduser", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findHobby(String userid) {
        System.out.println("执行查找");
        System.out.println("userid:" + userid);
        User user = userServer.findUser(new User(Long.parseLong(userid)));
        JSONObject jsonObject = new JSONObject();
        System.out.println("user:" + user.getId());
        jsonObject.put("userid", user.getId());
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());
        jsonObject.put("workbyuser", user.getWork().getWorkname());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("sex", user.getSex());
        jsonObject.put("birthday", user.getBirthday());
        jsonObject.put("userHobby", user.getHobby().getHobbyname());
        jsonObject.put("createDate", user.getCreatedate());
        System.out.println("userJSONObject:" + jsonObject);
        return jsonObject.toString();
    }

    /**
     * 编辑一个用户的信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "edituser", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String editUser(@ModelAttribute User user) {
        userServer.editUser(user);
        return "manage";
    }
}
