package com.haier.personal.logistics.controller;

import com.haier.personal.logistics.dto.ResultDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@ControllerAdvice
public class ExceptionAdapterController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionAdvice(Exception e){
        ResultDTO<String> resultDTO = new ResultDTO<>();
        resultDTO.setCode("9999");
        resultDTO.setMessage(e.getMessage());
        e.printStackTrace();
        return resultDTO;
    }
}
