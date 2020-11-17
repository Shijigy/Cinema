package com.gouyan.framework.exception;

import com.gouyan.common.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置异常处理器，管理全局异常
 * @Author: 华雨欣
 * @Create: 2020-11-17 23:33
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    //定义Logger，方便控制台显示错误信息
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理验证不通过异常，将错误信息响应给前端
     * @return 错误响应信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //打印日志
        log.error(e.getMessage(), e);
        //获取该异常的结果
        BindingResult bindingResult = e.getBindingResult();
        //获取错误msg
        String msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
        return ResponseResult.error(msg);
    }

}
