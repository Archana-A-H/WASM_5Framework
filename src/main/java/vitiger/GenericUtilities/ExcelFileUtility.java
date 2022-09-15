package vitiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class performs specified operations on the specified excel sheet
 * @author HP
 *
 */
public class ExcelFileUtility {
	/**
	 * This method reads data from the particular excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
	    Sheet s=wb.getSheet(sheet);
	    Row r = s.getRow(row);
	    Cell c = r.getCell(cell);
	    String value = c.getStringCellValue();
	    wb.close();
	    return value;    
	}
	/**
	 * This method returns total number of rows in the specified excel sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowcount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int lastrow = s.getLastRowNum();
		wb.close();
		return lastrow;
	}
	/**
	 * This method writes data into the specified excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcelSheet(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		c.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
    public Object[][] readMultiDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet s = wb.getSheet(sheetname);
    	int lastRow = s.getLastRowNum();
    	int lastCell = s.getRow(0).getLastCellNum();
    	
    	Object[][] data=new Object[lastRow][lastCell];
    	for(int i=0;i<lastRow;i++)
    	{
    		for(int j=0;j<lastCell;j++)
    		{
    			data[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
    		}
    	}
    	return data;
    }
}
