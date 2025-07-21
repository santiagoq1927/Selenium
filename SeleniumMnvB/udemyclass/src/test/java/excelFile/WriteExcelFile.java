package excelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
    
    public WriteExcelFile(){

    }

    public void writeExcel(String filePath, String sheetName, String[] dataWrite) throws IOException{

        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
        
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        XSSFRow row = newSheet.getRow(0);
        XSSFRow newRow = newSheet.createRow(rowCount+1);

        for(int i=0;i<row.getLastCellNum();i++){
            XSSFCell newCell = newRow.createCell(i);
            newCell.setCellValue(dataWrite[i]);
        }
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkBook.write(outputStream);

        outputStream.close();
    }

    public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException{

        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
        
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
        XSSFRow row = newSheet.getRow(0);

        XSSFCell firstCell = row.getCell(cellNumber-1);
        System.out.println("primer valor de celda: " + firstCell.getStringCellValue());
        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);
        System.out.println("siguiente celfa e: " + nextCell.getStringCellValue());
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkBook.write(outputStream);
        outputStream.close();
    }

     
}
