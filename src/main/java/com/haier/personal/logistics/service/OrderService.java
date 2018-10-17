package com.haier.personal.logistics.service;

import com.haier.personal.logistics.entity.CategoryInfo;
import com.haier.personal.logistics.entity.Order;
import com.haier.personal.logistics.entity.OrderInfo;

import java.util.List;

public interface OrderService {
    List<Order> findList(String id);
    int save(List<Order> list);
}
