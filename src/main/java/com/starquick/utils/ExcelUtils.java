package com.starquick.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.starquick.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.starquick.exceptions.FrameworkException;

/**
 * Utility class for handling Excel files.
 * <p>
 * This class provides functionality to read data from Excel sheets and return it as a list of maps.
 * Each map represents a row in the Excel sheet, with the column headers as keys and cell values as values.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class ExcelUtils {

    private ExcelUtils() {
        // Private constructor to prevent instantiation
    }

    private static List<Map<String, String>> list;

    /**
     * Retrieves test details from the specified Excel sheet.
     * <p>
     * This method reads data from an Excel sheet and returns it as a list of maps. Each map corresponds to a row
     * in the Excel sheet, with column headers used as keys and cell values as values. The first row of the sheet
     * is treated as the header row.
     * </p>
     * 
     * @param SheetName the name of the sheet to read data from.
     * @return a list of maps containing the data from the specified sheet.
     * @throws FrameworkException if an I/O error occurs while reading the Excel file.
     */
    public static List<Map<String, String>> getTestDetails(String SheetName) {
        try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelfilepath())) {
            try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
                XSSFSheet sheet = workbook.getSheet(SheetName);

                Map<String, String> map;
                list = new ArrayList<>();
                int lastRowNum = sheet.getLastRowNum();
                int lastColumnNum = sheet.getRow(0).getLastCellNum();

                for (int i = 1; i <= lastRowNum; i++) {
                    map = new HashMap<>();
                    for (int j = 0; j < lastColumnNum; j++) {
                        String key = sheet.getRow(0).getCell(j).getStringCellValue();
                        String value = sheet.getRow(i).getCell(j).getStringCellValue();
                        map.put(key, value);
                    }
                    list.add(map);
                }
            }
        } catch (IOException e) {
            throw new FrameworkException("An IO exception occurred while processing the Excel file", e);
        }

        return list;
    }
}
