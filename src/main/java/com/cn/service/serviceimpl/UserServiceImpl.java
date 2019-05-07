package com.cn.service.serviceimpl;

import com.cn.dao.SuserMapper;
import com.cn.dto.Suser;
import com.cn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private SuserMapper suserMapper;

    public Suser getUserInfo(String userId){
        Suser user = null;
        try {
            user = suserMapper.selectByPrimaryKey(userId);
            logger.info(user.getUsername());
        }catch (Exception E){
            logger.error(E.getMessage());
            throw E;
        }
        return  user;
    }
}
