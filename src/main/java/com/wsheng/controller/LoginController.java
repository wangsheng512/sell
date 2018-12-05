package com.wsheng.controller;

import com.lly835.bestpay.rest.type.Get;
import com.wsheng.config.ProjectUrlConfig;
import com.wsheng.constant.CookieConstant;
import com.wsheng.constant.RedisConstant;
import com.wsheng.dataobject.SellerInfo;
import com.wsheng.enums.ResultEnum;
import com.wsheng.service.SellerService;
import com.wsheng.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wsheng
 * @Date: 2018/8/28 11:15
 * @Description:
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    @GetMapping("/index")
    public ModelAndView index(){

        return new ModelAndView("login/login");
    }

   /* @GetMapping("login")
    public ModelAndView doLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpServletResponse response,
                                Map<String, Object> map){
         //SellerInfo sellerInfo =sellerService.findAdmin(username);
         if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
             return new ModelAndView("common/error");
         }
        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), username, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }*/
}
