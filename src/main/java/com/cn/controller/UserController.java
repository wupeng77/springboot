package com.cn.controller;

import com.cn.dto.Suser;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService  userService;
    @Autowired
    private StringRedisTemplate strRedis;
    @Autowired
    private RedisTemplate  redisTemplate;

    @GetMapping("/login")
    public ModelAndView getUserInfo(String userId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        Suser user = userService.getUserInfo(userId);
//        strRedis.opsForSet().add("1234","1234");
        redisTemplate.opsForValue().set(userId,userId);
        System.out.print(strRedis.opsForValue().get("wpeng")+"---");
        mv.addObject(user);
        return  mv;
    }
}
