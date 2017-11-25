package com.longya.pojo.vo;

import com.longya.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 20:09
 * Version:V1.0
 */
public class TbItemCount extends TbItem {

    private String catName;
    private String statusName;

    public String getStatusName() {
        if(super.getStatus()==1){
            statusName="正常";
        }else if(super.getStatus()==2){
            statusName="下架";
        }else{
            statusName="删除";
        }
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
