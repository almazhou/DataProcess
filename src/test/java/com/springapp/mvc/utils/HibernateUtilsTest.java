package com.springapp.mvc.utils;


import com.springapp.mvc.domain.Employee;
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
        HibernateUtils.truncateTableByName("Employee");
        employee = new Employee(5,"MVC","alma",5.0,1.5,new Date(),0.9,3.0,true,true);
    }

    @Test
    public void should_save_employee_in_hibernate() throws Exception {
        Employee savedEmployee = HibernateUtils.save(employee);

        assertThat(savedEmployee,sameInstance(employee));
    }

    @Test
    public void should_get_list_in_data_base() throws Exception {
    HibernateUtils.save(employee);
    List<Employee> list = HibernateUtils.list();

    assertThat(list.get(0).getName(),is("alma"));
    }

    @Test
    public void should_read_things_from_data_base() throws Exception {
       Employee employee1 = new Employee(5,"MVC","zhou",5.0,1.5,new Date(),0.9,3.0,true,true);
        Employee save = HibernateUtils.save(employee1);

        Employee readEmployee = HibernateUtils.read(save.getId());

        assertThat(readEmployee.getName(),is("zhou"));
    }

    @Test
    public void should_return_by_name_using_select() throws Exception {
        HibernateUtils.mockDateBase();

        List<String> strings = HibernateUtils.selectName();

        assertThat(strings.size(),is(4));
        assertThat(strings.get(0), is("zhou"));
    }

    @Test
    public void should_return_by_specific_feild_of_employee() throws Exception {
        HibernateUtils.mockDateBase();

        List name = HibernateUtils.selectByFieldName("name");

        assertThat((String) name.get(0),is("zhou"));
    }

    @Test
    @Ignore
    public void should_return_by_specific_condition() throws Exception {
        HibernateUtils.mockDateBase();

        List<Employee> list = HibernateUtils.selectByCondition("id = 1");

        assertThat(list.size(),is(1));
        assertThat(list.get(0).getId(),is(new Long(1)));
    }

    @Test
    public void should_delete_everything_from_table() throws Exception {
        HibernateUtils.mockDateBase();

        int removedItem = HibernateUtils.truncateTableByName("Employee");

        assertThat(removedItem,is(4));
    }

    @Test
    public void should_load_object_from_excel() throws Exception {
        HibernateUtils.loadFromExcel("data/EmployeeInformation.xls");

        List<Employee> list = HibernateUtils.list();
        assertThat(list.size(),is(2));
    }
}
