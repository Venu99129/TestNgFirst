package org.example.realTimeTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginDataProvider extends BasicTest{

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook("src/main/resources/datafile/Logincreddata.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "positiveCredentials")
    public Object[] validUserCredentials(){
        return new Object[]{new LoginData("standard_user","secret_sauce"),new LoginData("problem_user", "secret_sauce"),new LoginData("performance_glitch_user", "secret_sauce"),new LoginData("error_user","secret_sauce"),new LoginData("visual_user","secret_sauce")};
        //,new LoginData("locked_out_user", "secret_sauce")

//        XSSFSheet sheet = workbook.getSheet("positive");
//        return readData(sheet);
    }

    @DataProvider(name = "negitiveCredentals")
    public Object[] inValidCredentials(){
        //return new Object[]{new LoginData(" "," "),new LoginData("venu","oooo"),new LoginData("","oooo"),new LoginData("venu","")};

        XSSFSheet sheet = workbook.getSheet("wrong");
        return readData(sheet);
    }

    public static Object[] readData(XSSFSheet sheet){
        Object[] objArr = new Object[sheet.getLastRowNum()-1];

        for(int i=1;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            System.out.println(sheet.getLastRowNum());
            objArr[i-1] = new LoginData(getCellData(row.getCell(0)),getCellData(row.getCell(1)));
        }
        return objArr;
    }
    public static String getCellData(Cell cell){
        if(cell == null) return "";
        CellType cellType = cell.getCellType();
        return switch (cellType) {
            case STRING, NUMERIC -> cell.toString();
            case BLANK -> " ";
            default -> "";
        };
    }
}


