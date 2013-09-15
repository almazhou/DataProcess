package com.springapp.mvc.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;

import static java.lang.Double.parseDouble;

public class SpreadSheet {
    private final HSSFSheet sheet;

    public SpreadSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }
    public String getCellValue(int row, int column) {
        HSSFRow sheetRow = sheet.getRow(row);
        HSSFCell cell = sheetRow.getCell(column);

        if ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC) || (cell.getCellType() == Cell.CELL_TYPE_FORMULA)) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

    public Double getCellValueAsDouble(int row, int column) {
        String cellValueAsString = getCellValue(row, column);
        return cellValueAsString.trim().length() == 0 ? null : parseDouble(cellValueAsString);
    }
}
