package com.longya.service.impl;


import com.hdc.ddshop.dto.Order;
import com.hdc.ddshop.dto.Page;
import com.hdc.ddshop.dto.Result;
import com.longya.dao.TbItemCountMapper;
import com.longya.dao.TbItemMapper;
import com.longya.pojo.po.TbItem;
import com.longya.pojo.po.TbItemExample;
import com.longya.pojo.vo.TbItemCount;
import com.longya.pojo.vo.TbItemQuery;
import com.longya.service.ItemService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 13:58
 * Version:V1.0
 */


@Service
public class ItemServiceImp implements ItemService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper tbItemDao;

    @Autowired
    private TbItemCountMapper tbItemCountDao;

    @Override
    public TbItem getById(long item) {

       TbItem tbItem =  tbItemDao.selectByPrimaryKey(item);
        return tbItem;
    }

//    @Override
//    public List<TbItem> listItem() {
//        List<TbItem> list = null;
//        try{
//           list =  tbItemDao.selectByExample(null);
//        }catch (Exception e){
//            logger.error(e.getMessage(),e);
//            e.printStackTrace();
//        }
//        return list;
//    }

    @Override
    public Result<TbItemCount> listItemsByPage(Page page,Order order,TbItemQuery query) {
        Result<TbItemCount> result = null;
        try{
            Map<String,Object> map =new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //创建一个实体类进行响应
            result =  new Result<TbItemCount>();
            //对total进行设值
            result.setTotal(tbItemCountDao.countTbItem(map));
            result.setRows(tbItemCountDao.listTbItemsByPage(map));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateItemsByIds(List<Long> ids) {
        int i=0;
        try{
            //创建一个状态为3的商品
            TbItem recone =new TbItem();
            recone.setStatus((byte)3);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = tbItemDao.updateByExampleSelective(recone,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateItemsByIdsIUp(List<Long> ids) {
        int i=0;
        try{
            //创建一个状态为3的商品
            TbItem recone =new TbItem();
            recone.setStatus((byte)1);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = tbItemDao.updateByExampleSelective(recone,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateItemsByIdsDown(List<Long> ids) {
        int i=0;
        try{
            //创建一个状态为3的商品
            TbItem recone =new TbItem();
            recone.setStatus((byte)2);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = tbItemDao.updateByExampleSelective(recone,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}
