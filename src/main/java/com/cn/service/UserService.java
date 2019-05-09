package com.cn.service;

import com.cn.dto.Suser;

public interface UserService {
    /**
     *
     * @param userId
     * @return
     */
    public Suser getUserInfo(String userId);

    /**
     *
     * @param userDto
     * @return
     */
    public boolean loginCheck(Suser userDto);

    /**
     *
     * @param user
     * @return
     */
    public int insertUser(Suser user);
}
