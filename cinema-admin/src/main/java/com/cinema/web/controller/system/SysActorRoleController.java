package com.cinema.web.controller.system;

import com.cinema.common.response.ResponseResult;
import com.cinema.system.domin.SysActorRole;
import com.cinema.system.service.impl.SysActorRoleServiceImpl;
import com.cinema.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 演员角色控制器
 *
 */
@RestController
public class SysActorRoleController extends BaseController {

    @Autowired
    SysActorRoleServiceImpl sysActorRoleService;

    @GetMapping("/sysActorRole")
    public ResponseResult findAll(){
        startPage();
        List<SysActorRole> data = sysActorRoleService.findAll();
        return getResult(data);
    }

    @GetMapping("/sysActorRole/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysActorRoleService.findById(id));
    }

    @PostMapping("/sysActorRole")
    public ResponseResult add(@Validated @RequestBody SysActorRole sysActorRole){
        return getResult(sysActorRoleService.add(sysActorRole));
    }

    @PutMapping("/sysActorRole")
    public ResponseResult update(@Validated @RequestBody SysActorRole sysActorRole){
        return getResult(sysActorRoleService.update(sysActorRole));
    }

    @DeleteMapping("/sysActorRole/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysActorRoleService.delete(ids));
    }

}
