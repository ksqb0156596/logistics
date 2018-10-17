package com.haier.personal.logistics.entity;

public class Order extends OrderInfo {
    private CategoryInfo categoryInfo;

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }
}
