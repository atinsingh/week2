package ca.pragra.wd2.framwork.data;

import ca.pragra.wd2.framwork.config.FrameworkConfig;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {
    private Workbook workbook;

    public ExcelDataProvider() {
        Path path = Paths.get(FrameworkConfig.getProperty("datafile.location"), FrameworkConfig.getProperty("datafile.name"));

        try {
            InputStream inputStream = new FileInputStream(path.toFile());
            workbook = new XSSFWorkbook(inputStream);
        }catch (IOException ex){

        }
    }

    public List<Object []> getData(String sheetName, boolean skipHeader){
        List<Object []>  data = new ArrayList<>();  // row dat
        // for every row create a list
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.rowIterator();
        if(skipHeader){
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {//read all rows
            Row row  = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> cellData = new ArrayList<>();
            while (cellIterator.hasNext()) {  // read all cells
                Cell cell  = cellIterator.next();
                if(cell.getCellTypeEnum() == CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
                if(cell.getCellTypeEnum() == CellType.STRING){
                    cellData.add(cell.getStringCellValue());
                }
                if(cell.getCellTypeEnum() == CellType.NUMERIC){
                    cellData.add(cell.getNumericCellValue());
                }

            }
            data.add(cellData.toArray());

        }
        return data;
    }
}
