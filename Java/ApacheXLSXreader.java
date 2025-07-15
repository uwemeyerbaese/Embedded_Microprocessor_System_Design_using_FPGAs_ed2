// To compile use:
// javac -cp .:poi-3.8.jar:commons-codec-1.5.jar:poi-ooxml-3.8.jar:poi-ooxml-schemas-3.8.jar:xmlbeans-2.3.0.jar:stax-api-1.0.1.jar:dom4j-1.6.1.jar:xml-apis-1.0.b2.jar ApacheXLSXreader.java
// java  -cp .:poi-3.8.jar:commons-codec-1.5.jar:poi-ooxml-3.8.jar:poi-ooxml-schemas-3.8.jar:xmlbeans-2.3.0.jar:stax-api-1.0.1.jar:dom4j-1.6.1.jar:xml-apis-1.0.b2.jar ApacheXLSXreader
import java.io.*; // Needed for File stream

import org.apache.poi.xssf.usermodel.XSSFWorkbook; // XLSX work book
import org.apache.poi.xssf.usermodel.XSSFSheet; // XLSX work sheet
import org.apache.poi.ss.usermodel.*; // XLSX cell class and methods

public class ApacheXLSXreader {
  public static void main(String[] args) throws Exception {
    FileInputStream input_document = new FileInputStream("grades.xlsx");
    XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document);
    XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
    Cell cell;
    for (int r = 1; r <= 4; r++) // Lifting all grades by 3 points
      for (int c = 1; c <= 3; c++) {
        cell = my_worksheet.getRow(r).getCell(c);
        double d = cell.getNumericCellValue() + 3.0;
        d = (d > 100) ? 100.0 : d; // Ceiling at 100 points
        cell.setCellValue(d);
      }
    input_document.close();
    FileOutputStream output_file = new FileOutputStream("lifted.xlsx");
    my_xlsx_workbook.write(output_file);
    output_file.close();
  }
}

