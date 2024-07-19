package com.starquick.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.starquick.constants.FrameworkConstranst;
import com.starquick.exceptions.FrameworkException;

public final class ExcelUtils {
	private  ExcelUtils(){

	}
	static List<Map<String,String>> list;

	public static List<Map<String, String>> getTestDetails(String SheetName) {

		try(FileInputStream fs = new FileInputStream(FrameworkConstranst.getExcelfilepath())) {

			try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
				XSSFSheet sheet = workbook.getSheet(SheetName);

				Map<String, String> map = null;
				list = new ArrayList<>();
				int lastrownum = sheet.getLastRowNum();
				int lastcolumnnum= sheet.getRow(0).getLastCellNum();
					System.out.println(lastcolumnnum);
					System.out.println(lastrownum);
				for(int i =1;i<=lastrownum;i++) {
					map = new HashMap<String, String>();
					for(int j =0; j<lastcolumnnum;j++) {

						String key =  sheet.getRow(0).getCell(j).getStringCellValue();
						String value =  sheet.getRow(i).getCell(j).getStringCellValue();
						map.put(key, value);

					}
					list.add(map);
				}
			}
		}catch (IOException e) {	
			throw new FrameworkException("Some IO expection happends in Excel File");
		}

		return list ;
	}
}
