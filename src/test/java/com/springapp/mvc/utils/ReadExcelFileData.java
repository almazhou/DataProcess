package com.springapp.mvc.utils;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

public class ReadExcelFileData {
    private final File file;

    public ReadExcelFileData(String filePath) {
        this.file = new File(filePath);
    }
    public HSSFSheet getSheet(int indexSheet) throws IOException {
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        POIFSFileSystem fs = new POIFSFileSystem(input);
        input.close();
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        return wb.getSheetAt(indexSheet);
    }
}
