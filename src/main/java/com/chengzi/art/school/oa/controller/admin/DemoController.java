package com.chengzi.art.school.oa.controller.admin;

import com.chengzi.art.school.oa.dto.TableParamDto;
import com.chengzi.art.school.oa.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Controller
@RequestMapping("/admin/demo")
@Slf4j
public class DemoController {

    @RequestMapping(value = "/table", method = {RequestMethod.GET})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/demo/table");
        return mav;
    }

    @RequestMapping(value = "/tableinfo", method = {RequestMethod.POST})
    @ResponseBody
    public String tableinfo(String tableParam) {
        TableParamDto tableParamDto = JsonUtils.json2object(tableParam, TableParamDto.class);
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = tableParamDto.getStart(); i < tableParamDto.getStart() + tableParamDto.getLength(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name1", i+"");
            map.put("name2", i+"");
            map.put("name3", i+"");
            map.put("name4", i+"");
            map.put("name5", i+"");
            data.add(map);
        }
        Map<String, Object> tableResult = new HashMap<>();
        tableResult.put("draw", tableParamDto.getDraw());
        tableResult.put("recordsTotal", 100);
        tableResult.put("recordsFiltered", 100);
        tableResult.put("data", data);
        //tableResult.put("error", "未知错误");
        return JsonUtils.object2json(tableResult);
    }

    @RequestMapping(value = "/form", method = {RequestMethod.GET})
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/demo/form");
        return mav;
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.GET})
    public ModelAndView insert() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/demo/insert");
        return mav;
    }
}
