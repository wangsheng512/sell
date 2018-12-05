package com.wsheng.service;


import com.wsheng.dataobject.SellerInfo;

/**
 * 卖家端
 */
public interface SellerService {


    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

   /* *//**
     * 登录
     * @param username
     * @return
     *//*
    SellerInfo findAdmin(String username);*/
}
