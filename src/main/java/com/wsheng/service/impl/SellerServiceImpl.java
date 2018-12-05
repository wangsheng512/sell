package com.wsheng.service.impl;

import com.wsheng.dataobject.SellerInfo;
import com.wsheng.repository.SellerInfoRepository;
import com.wsheng.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }

    /*@Override
    public SellerInfo findAdmin(String username) {
        return sellerInfoRepository.findUser(username);
    }*/


}