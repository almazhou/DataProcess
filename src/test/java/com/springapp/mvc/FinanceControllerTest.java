package com.springapp.mvc;

import com.springapp.mvc.controller.FinanceController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FinanceControllerTest {

    private FinanceController financeController;

    @Before
    public void setUp() throws Exception {
        financeController = new FinanceController();


    }

    @Test
    public void should_return_correct_model_and_view() throws Exception {

        ModelAndView modelAndView = financeController.showIndex();

        assertThat(modelAndView,notNullValue());
        assertThat(modelAndView.getViewName(),is("index"));
    }

    @Test
    public void should_add_employee_information_into_data_base() throws Exception {
        ModelAndView modelAndView = financeController.showIndex();
        List<Employee> employeeList = (ArrayList<Employee>)modelAndView.getModel().get("employeeList");

        assertThat(employeeList.get(0),notNullValue());
        assertThat(employeeList.get(0).getName(),is("alma"));
    }

    @Test
    public void should_add_number_of_colomn_in_the_model() throws Exception {
        ModelAndView modelAndView = financeController.showIndex();

        assertThat((Integer) modelAndView.getModel().get("attributeCount"),is(10));
    }
}
