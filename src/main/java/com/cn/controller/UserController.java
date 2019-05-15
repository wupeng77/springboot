package com.cn.controller;

import com.cn.dto.Suser;
import com.cn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 准备登陆页面
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getUserInfo(String userId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        logger.info("mv", mv);
        return mv;
    }

    /**
     * 登陆检验
     *
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute Suser userDto) {

        ModelAndView mv = new ModelAndView();
        boolean loginFlag = userService.loginCheck(userDto);

        if (loginFlag) {
            mv.setViewName("success");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    /**
     * 注册用户
     *
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute Suser userDto) {
        ModelAndView mv = new ModelAndView();
        int successFlag = userService.insertUser(userDto);

        if (1 == successFlag) {
            mv.setViewName("success");
        } else {
            mv.setViewName("register");
        }
        return mv;
    }

    /**
     * 准备注册
     *
     * @return
     */
    @RequestMapping("/prepRegister")
    public ModelAndView prepRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
}
