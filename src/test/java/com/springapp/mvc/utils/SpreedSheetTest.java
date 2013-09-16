package com.springapp.mvc.utils;

import com.springapp.mvc.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpreedSheetTest {

    private String filePath;
    private ReadExcelFileData excelData;
    private SpreadSheet spreadSheet;

    @Before
    public void setUp() throws Exception {
        filePath = "data/EmployeeInformation.xls";
        excelData = new ReadExcelFileData(filePath);
        spreadSheet = new SpreadSheet(excelData.getSheet(0));


    }

    @Test
    public void shouldBeAbleToReadCellAsDouble() throws Exception {

        assertThat(spreadSheet.getCellValueAsDouble(1, 0), is(1.0));
        assertThat(spreadSheet.getCellValue(1,1),is("MVC"));
    }

    @Test
    public void should_get_long_value() throws Exception {
        Long cellValueAsLong = spreadSheet.getCellValueAsLong(1, 0);

        assertThat(cellValueAsLong,is(new Long(1)));
    }

    @Test
    public void should_create_employee_from_excel() throws Exception {
        List<Employee> employees = spreadSheet.buildEmployee();

        assertThat(employees.size(),is(2));
        assertThat(employees.get(0).getId(),is(new Long(1)));
        assertThat(employees.get(0).getName(),is("zhou"));
    }
}
