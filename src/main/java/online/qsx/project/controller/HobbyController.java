package online.qsx.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.qsx.project.model.Hobby;
import online.qsx.project.service.HobbyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

/**
 * Created by 84825 on 2018/1/16.
 */
@Controller
@RequestMapping(value = "hobby")
public class HobbyController {
    @Autowired
    private HobbyServer hobbyServer;

    /**
     * 查找所有爱好
     *
     * @return
     */
    @PostMapping(value = "findAllHobby", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAllHobby() {
        JSONArray jsonArray = new JSONArray();
        for (Hobby hobby : hobbyServer.findByHobby()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createDate = sdf.format(hobby.getCreatedate());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hobbyid", hobby.getId());
            jsonObject.put("hobbyname", hobby.getHobbyname());
            jsonObject.put("createname", createDate);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }

    /**
     * 保存爱好
     *
     * @param hobbyname
     * @return
     */
    @RequestMapping(value = "savehobby", method = {RequestMethod.POST, RequestMethod.GET})
    public String saveHobby(String hobbyname) {
        hobbyServer.saveHobby(hobbyname);
        return "manage";
    }

    /**
     * 删除
     *
     * @param hobbyid
     * @return
     */
    @RequestMapping(value = "removehobby", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String removeHobby(String hobbyid) {
        System.out.println("hobbyid:" + hobbyid);
        hobbyServer.removeHobby(Long.parseLong(hobbyid));
        return findAllHobby();
    }

    /**
     * 查找
     *
     * @param hobbyid
     * @return
     */
    @RequestMapping(value = "findhobby", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findHobby(String hobbyid) {
        System.out.println("执行查找");
        System.out.println("hobbyid:" + hobbyid);
        Hobby hobby = hobbyServer.findHobby(Long.parseLong(hobbyid));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hobbyname", hobby.getHobbyname());
        jsonObject.put("hobbyid", hobby.getId());
        System.out.println(jsonObject);
        return jsonObject.toString();
    }

    /**
     * 编辑
     *
     * @param hobby
     * @return
     */
    @RequestMapping(value = "edithobby", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String editHobby(@ModelAttribute Hobby hobby) {
        hobbyServer.saveEdit(hobby);
        return "manage";
    }
}
