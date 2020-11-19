package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysHallCategory;
import com.gouyan.system.service.impl.SysHallCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-19 21:39
 */

@RestController
public class SysHallCategoryController {
    @Autowired
    private SysHallCategoryServiceImpl sysHallCategoryService;

    @GetMapping("/sysHallCategory")
    public ResponseResult findAll(){
        List<SysHallCategory> data = sysHallCategoryService.findAll();
        return ResponseResult.success(data);
    }

    @GetMapping("/sysHallCategory/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return ResponseResult.success(sysHallCategoryService.findById(id));
    }

    @PostMapping("/sysHallCategory")
    public ResponseResult add(@Validated @RequestBody SysHallCategory sysHallCategory){
        sysHallCategoryService.add(sysHallCategory);
        return ResponseResult.success();
    }


    @PutMapping("/sysHallCategory")
    public ResponseResult update(@Validated @RequestBody SysHallCategory sysHallCategory){
        sysHallCategoryService.update(sysHallCategory);
        return ResponseResult.success();
    }

    @DeleteMapping("/sysHallCategory/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        sysHallCategoryService.delete(ids);
        return ResponseResult.success();
    }
}
