package com.cn.service;

import com.cn.dto.Suser;

public interface UserService {
    /**
     *
     * @param userId
     * @return
     */
    public Suser getUserInfo(String userId);
}
