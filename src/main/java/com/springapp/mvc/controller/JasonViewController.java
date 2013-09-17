package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Employee;
import com.springapp.mvc.utils.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        jsonView.getModel().put("employeeList",list);
        return jsonView;
    }
}
