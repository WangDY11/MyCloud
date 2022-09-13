package com.vilsale.common.controller;

import com.vilsale.common.util.IDUtil;
import com.vilsale.common.response.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc ID控制
 * @date 2020/4/14
 * @author wjy
 */
@Api(tags = "ID控制")
@RestController
public class IDController {

    @Autowired
    private IDUtil idUtil;

    @ApiOperation(value = "获取ID")
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public ResponseEntity id() {
        String id = idUtil.getID();
        return ResponseBuilder.success(id);
    }

}
