package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysHall;
import com.gouyan.system.service.impl.SysHallServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxd
 * @create 2020-11-25 11:14
 */

@RestController
public class SysHallController extends BaseController {

    @Autowired
    private SysHallServiceImpl sysHallService;

    @GetMapping("/sysHall")
    public ResponseResult findAll(SysHall sysHall){
        startPage();
        return getResult(sysHallService.findAll(sysHall));
    }

    @GetMapping("/sysHall/{cinemaId}/{hallId}")
    public ResponseResult findByPrimaryKey(@PathVariable Long cinemaId, @PathVariable Long hallId){
        SysHall sysHall = new SysHall();
        sysHall.setCinemaId(cinemaId);
        sysHall.setHallId(hallId);
        return getResult(sysHallService.findByCinemaIdAndHallId(sysHall));
    }

    @PostMapping("/sysHall")
    public ResponseResult add(@Validated @RequestBody SysHall sysHall){
        return getResult(sysHallService.add(sysHall));
    }

    @PutMapping("/sysHall")
    public ResponseResult update(@Validated @RequestBody SysHall sysHall){
        return getResult(sysHallService.update(sysHall));
    }

    @PostMapping("/sysHall/delete")
    public ResponseResult delete(@RequestBody SysHall[] sysHalls){
        return getResult(sysHallService.delete(sysHalls));
    }

}
