package com.springapp.mvc;

import com.springapp.mvc.controller.JasonViewController;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JasonViewControllerTest {
    @Test
    public void should_return_data_base_information() throws Exception {
        JasonViewController jasonViewController = new JasonViewController();

        ModelAndView employeeInformation = jasonViewController.getEmployeeInformation();

        assertThat(employeeInformation,notNullValue());
        assertThat(employeeInformation.getViewName(),is("jsonView"));
        List<Employee> employeeList = (List<Employee>) employeeInformation.getModel().get("employeeList");
        assertThat(employeeList.get(0).getName(),is("zhou"));
    }
}
