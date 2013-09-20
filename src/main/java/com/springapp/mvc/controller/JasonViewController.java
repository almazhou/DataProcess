package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Employee;
import com.springapp.mvc.utils.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JasonViewController {
    private FinanceDAO dao;

    @Autowired
    public JasonViewController(FinanceDAO dao) {
        this.dao = dao;
    }

    public JasonViewController() {
    }

    @RequestMapping("/json/employeeList")
    public ModelAndView employeeInformation() {
        ModelAndView jsonView = new ModelAndView("jsonView");
        List<Employee> list = HibernateUtils.list();
        jsonView.getModel().put("employeeList", list);
        return jsonView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView doSearch(@RequestBody String condition) {
        ModelAndView jsonView = new ModelAndView("jsonView");
        String[] split = condition.split("=");
        List<Employee> list = null;
        String att = split[1];
        list = HibernateUtils.selectByCondition(condition);
//        if (isNumeric(att)){
//            list = HibernateUtils.selectByCondition(condition);
//        }else{
//            String conditionStr = split[0]+"=\'"+att+"\'";
//            list = HibernateUtils.selectByCondition(conditionStr);
//        }
        jsonView.getModel().put("employeeList", list);
        return jsonView;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
