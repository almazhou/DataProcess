package com.springapp.mvc.controller;

import com.springapp.mvc.Employee;
import com.springapp.mvc.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JasonViewController {
    @RequestMapping("/json/employeeList")
    public ModelAndView getEmployeeInformation() {
        ModelAndView jsonView = new ModelAndView("jsonView");
        HibernateUtils.mockDateBase();
        List<Employee> list = HibernateUtils.list();
        jsonView.getModel().put("employeeList",list);
        return jsonView;
    }
}
