package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Employee;
import com.springapp.mvc.utils.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String doDelete(@RequestBody String employeeId) {
        List<Employee> list = HibernateUtils.selectByCondition("id =" + employeeId);
        if(list.size()==1&&list.get(0).getId().toString().equals(employeeId)){
            Employee employee = list.get(0);
            HibernateUtils.delete(employee);
        }
        return "index";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doEdit(@RequestBody String employee) {
        String[] employeeInfo = employee.split("&");
        List<Employee> list = HibernateUtils.selectByCondition(employeeInfo[0]);
        Employee updatedEmployee = list.get(0);
        updatedEmployee.setName(searchFor("name",employeeInfo));
        updatedEmployee.setAccount(searchFor("account", employeeInfo));
        updatedEmployee.setOnceOut(Boolean.parseBoolean(searchFor("onceOut",employeeInfo)));
        updatedEmployee.setTimeInTW(Double.parseDouble(searchFor("timeInTW",employeeInfo)));
        updatedEmployee.setGraduate(Boolean.parseBoolean(searchFor("graduate",employeeInfo)));
        updatedEmployee.setTotalWorkYear(Double.parseDouble(searchFor("totalWorkYear",employeeInfo)));
        updatedEmployee.setTimeToJoin(new Date());
        updatedEmployee.setRate(Double.parseDouble(searchFor("rate",employeeInfo)));
        updatedEmployee.setTimeOnThisAccount(Double.parseDouble(searchFor("timeOnThisAccount",employeeInfo)));
        HibernateUtils.update(updatedEmployee);
        return "index";
    }

    private String searchFor(String name, String[] employeeInfo) {
        for(String str:employeeInfo){
            if(str.startsWith(name)){
                return str.split("=")[1].trim();
            }
        }
        return null;
    }


}
