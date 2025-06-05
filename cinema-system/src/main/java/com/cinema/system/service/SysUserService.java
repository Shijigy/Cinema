package com.cinema.system.service;

import com.cinema.system.domin.LoginUser;
import com.cinema.system.domin.SysMovie;
import com.cinema.system.domin.SysUser;
import com.cinema.system.domin.vo.SysUserVo;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-22 21:42
 */
public interface SysUserService {
    List<SysUser> findAll(SysUser sysUser);

    SysUser findById(Long id);

    SysUser findByName(String userName);

    int add(SysUser sysUser);

    int update(SysUser sysUser);

    int delete(Long[] ids);

    LoginUser login(SysUserVo sysUserVo);

    LoginUser findLoginUser(SysUserVo sysUserVo);

    boolean isUserNameUnique(String userName, Long userId);
}
