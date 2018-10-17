package com.haier.personal.logistics.service.impl;

import com.haier.personal.logistics.dao.OrderInfoDAO;
import com.haier.personal.logistics.entity.CategoryInfo;
import com.haier.personal.logistics.entity.Order;
import com.haier.personal.logistics.entity.OrderInfo;
import com.haier.personal.logistics.service.OrderService;
import com.haier.personal.logistics.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoDAO orderInfoDAO;

    @Override
    public List<Order> findList(String id) {
        return orderInfoDAO.findList(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(List<Order> list) {
        String temp = "";
        for(Order o : list){
            if(!temp.equals(o.getOrderNo())){
                orderInfoDAO.insertOrderInfo(o);
                temp = o.getOrderNo();
            }
            orderInfoDAO.insertCategoryInfo(o.getCategoryInfo());
        }
        return 0;
    }

}
