package com.wsheng.repository;

import com.wsheng.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * wsheng
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

//    SellerInfo findUser(String username );
}
