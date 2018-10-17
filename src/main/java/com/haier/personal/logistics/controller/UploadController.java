package com.haier.personal.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.haier.personal.logistics.dto.ResultDTO;
import com.haier.personal.logistics.entity.Order;
import com.haier.personal.logistics.service.OrderService;
import com.haier.personal.logistics.util.ExcelUtil;
import com.haier.personal.logistics.util.MessageEnum;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/upload")
    public ResultDTO<List<Order>> upload(MultipartFile file, HttpServletRequest request){
        ExcelUtil excelUtil = new ExcelUtil();
        try {
            List<Order> list = excelUtil.parseExcel(file.getInputStream(), file.getOriginalFilename());
            orderService.save(list);
            return new ResultDTO<>(MessageEnum.C0000, list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(MessageEnum.C0000);
    }

}
