package com.haier.personal.logistics.util;

import com.haier.personal.logistics.entity.CategoryInfo;
import com.haier.personal.logistics.entity.Order;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public List<Order> parseExcel(InputStream in, String filename) throws IOException, InvalidFormatException, ParseException {
        try {
            Workbook workbook;
            if(filename.lastIndexOf(".xlsx") > -1){
                workbook = new XSSFWorkbook(in);
            }else{
                workbook = new HSSFWorkbook(in);
            }
            Sheet sheet = workbook.getSheetAt(0);
            List<Order> result = new ArrayList<>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            for(int i = 1;i < sheet.getPhysicalNumberOfRows();i++){
                Row row = sheet.getRow(i);
                if(isTheLast(row)){
                    break;
                }
                Order order = new Order();
                order.setOrderNo(getCell(row.getCell(0)));
                order.setAddress(getCell(row.getCell(1)));
                order.setConsignee(getCell(row.getCell(2)));
                order.setTelphone(getCell(row.getCell(3)));
                CategoryInfo categoryInfo = new CategoryInfo();
                categoryInfo.setOrderNo(order.getOrderNo());
                categoryInfo.setExpressName(getCell(row.getCell(4)));
                categoryInfo.setExpressNumber(getCell(row.getCell(5)));
                categoryInfo.setCategoryName(getCell(row.getCell(6)));
                categoryInfo.setCategoryCount(getCell(row.getCell(7)));
                categoryInfo.setRemark(getCell(row.getCell(8)));
                categoryInfo.setSendDate(simpleDateFormat.parse(getCell(row.getCell(9))));
                order.setCategoryInfo(categoryInfo);
                result.add(order);
            }
            return result;
        }finally {
            in.close();
        }
    }

//    public static void main(String[] args) throws IOException, InvalidFormatException, ParseException {
//        File file = new File("D:/1111.xlsx");
//        ExcelUtil excelUtil = new ExcelUtil();
//        System.out.println(JSON.toJSONString(excelUtil.parseExcel(file)));
//    }

    private boolean isTheLast(Row row){
        for (Cell cell : row){
            if(!StringUtils.isEmpty(getCell(cell))){
                return false;
            }
        }
        return true;
    }

    private String getCell(Cell cell){
        Object obj;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                obj = null;
                break;
        }
        return String.valueOf(obj);
    }
}
