package com.haier.personal.logistics.dao;

import com.haier.personal.logistics.entity.CategoryInfo;
import com.haier.personal.logistics.entity.Order;
import com.haier.personal.logistics.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoDAO {
    List<Order> findList(@Param(value = "id") String id);
    int insertOrderInfo(OrderInfo orderInfo);
    int insertCategoryInfo(CategoryInfo categoryInfo);
}
