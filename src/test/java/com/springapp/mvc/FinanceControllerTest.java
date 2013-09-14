package com.springapp.mvc;

import com.springapp.mvc.controller.FinanceController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

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


}
