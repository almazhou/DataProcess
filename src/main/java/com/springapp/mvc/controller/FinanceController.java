package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Employee;
import com.springapp.mvc.utils.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class FinanceController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {

        ModelAndView index = new ModelAndView("index");
        index.getModel().put("message", "ThoughtWorks index page");
        return index;
    }
    @RequestMapping(value = "/saveForm", method = RequestMethod.POST)
    public String doForm(@RequestParam("id")String id,@RequestParam("name")String name,
                         @RequestParam("name")String account,@RequestParam("rate") String rate,
                         @RequestParam("timeToJoin") String timeToJoin,@RequestParam("totalWorkYear") String totalWorkYear,
                         @RequestParam("timeInTW") String timeInTW,@RequestParam("graduate") String graduate,
                         @RequestParam("onceOut") String onceOut,@RequestParam("timeOnThisAccount") String timeOnThisAccount) {
        long id0 = Long.parseLong(id);
        double rate0 = Double.parseDouble(rate);
        double totalWorkYear0 = Double.parseDouble(totalWorkYear);
        double timeInTW0 = Double.parseDouble(timeInTW);
        boolean graduate0 = Boolean.parseBoolean(graduate);
        boolean onceOut0 = Boolean.parseBoolean(onceOut);
        double timeOnThisAccount0 = Double.parseDouble(timeOnThisAccount);

        Employee employee = new Employee(id0, account, name, rate0, timeInTW0, new Date(), timeOnThisAccount0, totalWorkYear0, graduate0, onceOut0);
        HibernateUtils.save(employee);
        return "index";
    }

}
