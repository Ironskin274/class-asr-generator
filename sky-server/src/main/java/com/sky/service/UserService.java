package com.sky.service;

import com.sky.dto.UserDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {

    /**
     * 员工登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 新增员工
     * @param userDTO
     */
    void save(UserDTO userDTO);
}
