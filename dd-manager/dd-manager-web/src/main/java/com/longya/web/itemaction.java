package com.longya.web;

import com.hdc.ddshop.dto.Order;
import com.hdc.ddshop.dto.Page;
import com.hdc.ddshop.dto.Result;
import com.longya.pojo.po.TbItem;
import com.longya.pojo.vo.TbItemCount;
import com.longya.pojo.vo.TbItemQuery;
import com.longya.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 13:37
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class itemaction {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{item}", method = RequestMethod.GET)

    public TbItem getBIdy(@PathVariable("item") long item) {
        System.out.println(item);
        TbItem tbItem= itemService.getById(item);
        return tbItem;
    }

//    @ResponseBody
//    @RequestMapping("/items")
//    public List<TbItem> listItem(){
//        List<TbItem> list =null;
//        try{
//            list = itemService.listItem();
//        }catch(Exception e){
//            logger.error(e.getMessage(),e);
//            e.printStackTrace();
//        }
//        return list;
//    }

    @ResponseBody
    @RequestMapping("/items/batch")
    public int updateItemsByIds(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.updateItemsByIds(ids);
        }catch (Exception e){
           logger.error(e.getMessage(),e);
           e.printStackTrace();
        }
        return i;
    }


    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCount> listItemsByPage(Page page, Order order, TbItemQuery query){
        Result<TbItemCount> list=null;
       try{
           list = itemService.listItemsByPage(page,order,query);
       }catch (Exception e){
           e.printStackTrace();
       }
       return list;
    }



    @RequestMapping(value="/{page}")
    public String Page(@PathVariable("page") String page){
        return page;
    }

    @ResponseBody
    @RequestMapping("/items/up")
    public int updateItemsByIdsUp(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.updateItemsByIdsIUp(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/items/down")
    public int updateItemsByIdsDown(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.updateItemsByIdsDown(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}
