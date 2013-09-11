package com.springapp.mvc;

import com.springapp.mvc.controller.FinanceController;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FinanceControllerTest {
    @Test
    public void should_return_correct_model_and_view() throws Exception {
        FinanceController financeController = new FinanceController();

        ModelAndView modelAndView = financeController.showIndex();

        assertThat(modelAndView,notNullValue());
        assertThat(modelAndView.getViewName(),is("index"));
    }


}
