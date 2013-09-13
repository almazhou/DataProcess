package com.springapp.mvc.controller;

import com.springapp.mvc.Employee;
import com.springapp.mvc.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FinanceController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {

        ModelAndView index = new ModelAndView("index");
        index.getModel().put("message", "ThoughtWorks index page");
        HibernateUtils.mockDateBase();
        List<Employee> list = HibernateUtils.list();
        index.getModel().put("employeeList",list);
        index.getModel().put("attributeCount",new Employee().getColumnCount());
        return index;
    }

}
