package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysCinema;
import com.gouyan.system.service.impl.SysCinemaServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxd
 * @create 2020-11-25 22:41
 */
@RestController
public class SysCinemaController extends BaseController {

    @Autowired
    private SysCinemaServiceImpl sysCinemaService;

    @GetMapping("/sysCinema")
    public ResponseResult findAll(SysCinema sysCinema){
        startPage();
        return getResult(sysCinemaService.findAll(sysCinema));
    }

    @GetMapping("/sysCinema/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysCinemaService.findById(id));
    }

    @PostMapping("/sysCinema")
    public ResponseResult add(@Validated @RequestBody SysCinema sysCinema){
        return getResult(sysCinemaService.add(sysCinema));
    }

    @PutMapping("/sysCinema")
    public ResponseResult update(@Validated @RequestBody SysCinema sysCinema){
        return getResult(sysCinemaService.update(sysCinema));
    }

    @DeleteMapping("/sysCinema/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysCinemaService.delete(ids));
    }

}
