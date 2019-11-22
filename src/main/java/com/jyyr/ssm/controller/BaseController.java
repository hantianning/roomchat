package com.jyyr.ssm.controller;

import com.jyyr.ssm.entity.ResponseResult;
import com.jyyr.ssm.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<Void> handleException(Exception e){
        if(e instanceof PhoneConflictException){
            return new ResponseResult<Void>(3000,e);
        }else if(e instanceof UserNotFoundException){
            return new ResponseResult<Void>(3002,e);
        }else if(e instanceof InsertDataException){
            return new ResponseResult<Void>(3003,e);
        }else if(e instanceof PasswordNotMatchException){
            return new ResponseResult<Void>(3004,e);
        }else{
            return new ResponseResult<Void>(6060,e);
        }
    }
}
