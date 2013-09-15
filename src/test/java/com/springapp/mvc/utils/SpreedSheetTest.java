package com.springapp.mvc.utils;

import org.junit.Before;
import org.junit.Test;

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

}
