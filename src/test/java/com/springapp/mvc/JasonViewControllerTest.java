package com.springapp.mvc;

import com.springapp.mvc.controller.JasonViewController;
import com.springapp.mvc.domain.Employee;
import com.springapp.mvc.utils.HibernateUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JasonViewControllerTest {

    private JasonViewController jasonViewController;

    @Before
    public void setUp() throws Exception {
        HibernateUtils.truncateTableByName("Employee");
        HibernateUtils.loadFromExcel("temp/EmployeeInformation.xls");
        jasonViewController = new JasonViewController();
    }

    @Test
    public void should_return_data_base_information() throws Exception {

        ModelAndView employeeInformation = jasonViewController.employeeInformation();

        assertThat(employeeInformation,notNullValue());
        assertThat(employeeInformation.getViewName(),is("jsonView"));
        List<Employee> employeeList = (List<Employee>) employeeInformation.getModel().get("employeeList");
        assertThat(employeeList.get(0).getName(),is("zhou"));
    }

    @Test
    public void should_convert_excel_to_object() throws Exception {
        ModelAndView employeeInformation = jasonViewController.employeeInformation();
        List<Employee> employeeList = (List<Employee>) employeeInformation.getModel().get("employeeList");

        assertThat(employeeList.size(),is(2));
    }
}
