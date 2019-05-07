package com.cn.service.serviceimpl;

import com.cn.dao.SuserMapper;
import com.cn.dto.Suser;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SuserMapper suserMapper;

    public Suser getUserInfo(String userId){
        Suser user = null;
        try {
            System.out.print(suserMapper);
            user = suserMapper.selectByPrimaryKey(userId);
        }catch (Exception E){
            E.printStackTrace();
        }
        return  user;
    }
}
