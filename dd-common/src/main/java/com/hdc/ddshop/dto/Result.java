package com.hdc.ddshop.dto;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 16:50
 * Version:V1.0
 */
public class Result<T> {
    //查询的总条数
    private long total;
    //每次查询结果存放的地方
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
