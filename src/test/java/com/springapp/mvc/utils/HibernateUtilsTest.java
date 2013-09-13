package com.springapp.mvc.utils;


import com.springapp.mvc.Employee;
import com.springapp.mvc.HibernateUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HibernateUtilsTest {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee(5,"MVC","alma",5.0,1.5,new Date(),0.9,3.0,true,true);
    }

    @Test
    public void should_save_employee_in_hibernate() throws Exception {
        Employee savedEmployee = HibernateUtils.save(employee);

        assertThat(savedEmployee,sameInstance(employee));
    }

    @Test
    public void should_get_list_in_data_base() throws Exception {
    List<Employee> list = HibernateUtils.list();

    assertThat(list.get(0).getName(),is("alma"));
    }

    @Test
    public void should_read_things_from_data_base() throws Exception {
       Employee employee1 = new Employee(5,"MVC","zhou",5.0,1.5,new Date(),0.9,3.0,true,true);
       HibernateUtils.save(employee1);
        Employee readEmployee = HibernateUtils.read(2);

        assertThat(readEmployee.getName(),is("zhou"));
    }

    @Test
    public void should_update_item_in_data_base() throws Exception {
        employee.setName("ssss");
        Employee update = HibernateUtils.update(employee);

        List<Employee> list = HibernateUtils.list();

        assertThat(list.get(2).getName(),is("ssss"));
    }

    @Test
    @Ignore
    public void should_delete_item_in_the_data_base() throws Exception {
        List<Employee> list = HibernateUtils.list();
        int size = list.size();
        HibernateUtils.delete(employee);

        List<Employee> list1 = HibernateUtils.list();
        assertThat(list1.size()-size, is(1));
    }
}
