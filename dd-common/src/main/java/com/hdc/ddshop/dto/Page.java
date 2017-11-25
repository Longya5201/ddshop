package com.hdc.ddshop.dto;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 16:31
 * Version:V1.0
 */
public class Page {


    /*

    page 当前页的页码
    rows 每页显示多少条数据
     */
    private int page;
    private int rows;

    //偏移量（当前页的第一条记录的索引号）
    //private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    //获取偏移量，不需要手动设置
    public int getOffset() {
        return (page - 1) * rows;
    }
}

