package util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import entity.QuestionEntity;

public class ReadExcelUtil
{

    private final static String XLS = "XLS";
    private final static String XLSX = "XLSX";

    /**
     * 读入excel文件，解析后返回
     *
     * @param file excel文件
     * @throws IOException 抛出异常
     */
    public static List<String[]> readExcel(File file) throws IOException
    {
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<>();
        if (workbook != null)
        {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++)
            {
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null)
                {
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++)
                {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null)
                    {
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    //循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++)
                    {
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }

    private static Workbook getWorkBook(File file)
    {
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try
        {
            //获取excel文件的io流
            InputStream is = new FileInputStream(file);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            String fileName = file.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (suffix.equalsIgnoreCase(XLS))
            {
                //2003
                workbook = new HSSFWorkbook(is);
            }
            else if (suffix.equalsIgnoreCase(XLSX))
            {
                //2007
                workbook = new XSSFWorkbook(is);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return workbook;
    }

    private static String getCellValue(Cell cell)
    {
        String cellValue = "";
        if (cell == null)
        {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
        {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType())
        {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("d:\\1514454461808_试题.xlsx");
        ArrayList<String[]> list = (ArrayList<String[]>) readExcel(file);
        for (String[] strings : list)
        {
            int courseID = Integer.parseInt(strings[0]);
            String stem = strings[1];
            String a = strings[2];
            String b = strings[3];
            String c = strings[4];
            String d = strings[5];
            String answer = strings[6];
            BigDecimal score = BigDecimal.valueOf(Long.parseLong(strings[7]));
            QuestionEntity questionEntity = new QuestionEntity(courseID, a, b, c, d, answer, score, stem);
            System.out.println(questionEntity);
        }
    }
}
