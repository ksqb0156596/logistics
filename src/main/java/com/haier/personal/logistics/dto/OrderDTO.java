package com.haier.personal.logistics.dto;

import com.haier.personal.logistics.entity.CategoryInfo;
import com.haier.personal.logistics.entity.OrderInfo;

import java.util.List;

public class OrderDTO extends OrderInfo{
    private List<CategoryInfo> list;

    public List<CategoryInfo> getList() {
        return list;
    }

    public void setList(List<CategoryInfo> list) {
        this.list = list;
    }
}
