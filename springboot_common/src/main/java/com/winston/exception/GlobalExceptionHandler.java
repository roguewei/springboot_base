package com.winston.exception;

import com.winston.result.CodeMsg;
import com.winston.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 * 自定义异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
      * @Author Winston
      * @Description 捕获权限不足时抛出的异常
      * @Date 11:24 2019/7/13
      * @Param
      * @return
      **/
    @ExceptionHandler(value = ErrorException.class)
    Result errorException(ErrorException errorException){
        return Result.error(errorException.getCodeMsg());
    }

}
