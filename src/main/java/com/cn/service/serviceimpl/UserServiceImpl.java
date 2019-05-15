package com.cn.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.cn.dao.SuserMapper;
import com.cn.dto.Suser;
import com.cn.dto.SuserExample;
import com.cn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private SuserMapper suserMapper;

    public Suser getUserInfo(String userId){
        Suser user = null;
        try {
            user = suserMapper.selectByPrimaryKey(userId);
        }catch (Exception E){
            logger.error(E.getMessage());
            throw E;
        }
        return  user;
    }

    @Override
    public boolean loginCheck(Suser userDto) {
        SuserExample suserExample = new SuserExample();
        SuserExample.Criteria cri = suserExample.createCriteria();
        cri.andUsernameEqualTo(userDto.getUsername());
        cri.andPasswordEqualTo(userDto.getPassword());
        logger.info(JSON.toJSONString(suserExample));
        List userList = suserMapper.selectByExample(suserExample);
        if (userList == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int insertUser(Suser user) {
        //以时间作为用户id
        Long userId = new Date().getTime();
        user.setUserid(userId.toString());
        return suserMapper.insert(user);
    }
}
