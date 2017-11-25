package com.longya.service;

import com.hdc.ddshop.dto.Order;
import com.hdc.ddshop.dto.Page;
import com.hdc.ddshop.dto.Result;
import com.longya.pojo.po.TbItem;
import com.longya.pojo.vo.TbItemCount;
import com.longya.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 13:45
 * Version:V1.0
 */
public interface ItemService {

    TbItem getById(long item);
   // public List<TbItem> listItem();

    int updateItemsByIds(List<Long> ids);

    int updateItemsByIdsIUp(List<Long> ids);

    int updateItemsByIdsDown(List<Long> ids);

    Result<TbItemCount> listItemsByPage(Page page, Order order,TbItemQuery query);
}
