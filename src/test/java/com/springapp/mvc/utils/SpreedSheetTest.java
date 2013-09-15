package com.springapp.mvc.utils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpreedSheetTest {
    @Test
    public void shouldBeAbleToReadCellAsDouble() throws Exception {
        String sampleDataFilePath = "data/EmployeeInformation.xls";
        ReadExcelFileData readExcelFileData = new ReadExcelFileData(sampleDataFilePath);
        SpreadSheet spreadSheet = new SpreadSheet(readExcelFileData.getSheet(0));

        assertThat(spreadSheet.getCellValueAsDouble(1, 0), is(1.0));
        assertThat(spreadSheet.getCellValue(1,1),is("MVC"));
//        assertThat(spreadSheet.getCellValueAsDouble(335, 1), nullValue());
    }
}
