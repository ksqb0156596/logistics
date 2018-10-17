package com.haier.personal.logistics.controller;

import com.haier.personal.logistics.dto.ResultDTO;
import com.haier.personal.logistics.entity.Order;
import com.haier.personal.logistics.service.OrderService;
import com.haier.personal.logistics.util.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findList")
    public ResultDTO<List<Order>> findList(String id){
        return new ResultDTO<>(MessageEnum.C0000,orderService.findList(id));
    }
}
