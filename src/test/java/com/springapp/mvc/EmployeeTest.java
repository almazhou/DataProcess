package com.springapp.mvc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Test
    public void should_get_the_feilds_number() throws Exception {
        Employee employee = new Employee();

        int columnCount = employee.getColumnCount();

        assertThat(columnCount,is(10));
    }
}
