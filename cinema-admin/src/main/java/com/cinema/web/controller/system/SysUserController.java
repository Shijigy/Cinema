package com.cinema.web.controller.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.cinema.common.response.ResponseResult;
import com.cinema.common.utils.StringUtil;
import com.cinema.system.domin.LoginUser;
import com.cinema.system.domin.SysUser;
import com.cinema.system.domin.vo.SysUserVo;
import com.cinema.system.service.impl.SysUserServiceImpl;
import com.cinema.web.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SysUserController extends BaseController {
    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping("/sysUser")
    public ResponseResult findAll(SysUser sysUser){
        startPage();
        List<SysUser> data = sysUserService.findAll(sysUser);
        return getResult(data);
    }

    @GetMapping("/sysUser/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysUserService.findById(id));
    }

    /**
     * 添加用户请求，注册也在这里
     * @param sysUser
     * @return
     */
    @PostMapping("/sysUser")
    public ResponseResult add(@Validated @RequestBody SysUser sysUser){
        return getResult(sysUserService.add(sysUser));
    }

    @PutMapping("/sysUser")
    public ResponseResult update(@Validated @RequestBody SysUser sysUser){
        return getResult(sysUserService.update(sysUser));
    }

    @DeleteMapping("/sysUser/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysUserService.delete(ids));
    }

    //用户登录
    @RequestMapping("/sysUser/login")
    public ResponseResult login(@RequestBody SysUserVo sysUserVo){
        return getResult(sysUserService.login(sysUserVo));
    }
}
