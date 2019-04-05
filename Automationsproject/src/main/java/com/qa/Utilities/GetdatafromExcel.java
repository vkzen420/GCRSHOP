package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdatafromExcel {
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public GetdatafromExcel(String ExcelPath) {

		try {
			File f = new File(ExcelPath);

			FileInputStream fis = new FileInputStream(f);

			wb = new XSSFWorkbook(fis);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getdata(int sheetnumber, int row, int col) {

		sheet = wb.getSheetAt(sheetnumber);
		DataFormatter Formatter = new DataFormatter();
		String data = Formatter.formatCellValue(sheet.getRow(row).getCell(col));
        //String data = Exceldata.toString();
		return data;

	}

}
