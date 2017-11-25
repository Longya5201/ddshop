package com.longya.dao;


import com.longya.pojo.vo.TbItemCount;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 17:34
 * Version:V1.0
 */
public interface TbItemCountMapper {

    //获取查询的记录
    long countTbItem(Map<String,Object> map);

    //分页查询的结果集合
   // List<TbItemCount> listTbItemsByPage(@Param(value="page") Page page, @Param (value="order") Order order);
    List<TbItemCount> listTbItemsByPage(Map<String,Object> map);
}
