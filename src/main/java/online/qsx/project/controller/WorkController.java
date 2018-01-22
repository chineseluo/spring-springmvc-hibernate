package online.qsx.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import online.qsx.project.model.Hobby;
import online.qsx.project.model.Work;
import online.qsx.project.service.HobbyServer;
import online.qsx.project.service.WorkServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

/**
 * Created by 84825 on 2018/1/16.
 */
@Controller
@RequestMapping(value = "work")
public class WorkController {

    @Autowired
    private WorkServer workServer;
    @Autowired
    private HobbyServer hobbyServer;

    /**
     * 返回管理系统页面
     *
     * @return
     */
    @GetMapping(value = "worklist")
    public String fun() {
        return "manage";
    }

    /**
     * 查找所有职业信息
     *
     * @return
     */
    @PostMapping(value = "findAllWork", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAllWork() {
        JSONArray jsonArray = new JSONArray();
        for (Work work : workServer.findAllWork()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createDate = sdf.format(work.getCreatedate());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("workid", work.getId());
            jsonObject.put("workname", work.getWorkname());
            jsonObject.put("createname", createDate);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }

    /**
     * 保存职业信息
     *
     * @param workname
     * @return
     */
    @PostMapping(value = "savework")
    public String saveWork(String workname) {
        workServer.saveWork(workname);
        return "manage";
    }

    /**
     * 根据id删除职业信息
     *
     * @param workid
     * @return
     */
    @RequestMapping(value = "removework", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String removeWork(String workid) {
        System.out.println("workid:" + workid);
        workServer.removeWork(Long.parseLong(workid));
        return findAllWork();
    }

    /**
     * 根据传入的id进行查找
     *
     * @param workid
     * @return
     */
    @RequestMapping(value = "findwork", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findHobby(String workid) {
        Work work = workServer.findWork(Long.parseLong(workid));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("workname", work.getWorkname());
        jsonObject.put("workid", work.getId());
        return jsonObject.toString();
    }

    /**
     * 编辑
     *
     * @param work
     * @return
     */
    @RequestMapping(value = "editwork", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String editWork(@ModelAttribute Work work) {
        workServer.saveEdit(work);
        return "manage";
    }
}
