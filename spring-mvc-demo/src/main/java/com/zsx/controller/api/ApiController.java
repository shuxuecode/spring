package com.zsx.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(value="用户controller",description="用户相关操作")
public class ApiController {

    @ApiOperation(value = "value值", notes = "notes值")
    @RequestMapping(value = "name", method = RequestMethod.GET)
    @ResponseBody
    public String get(
            @ApiParam(name = "name", value = "名称", required = true)
            @RequestParam(value = "name", required = true) String name){
        return name;
    }

}
