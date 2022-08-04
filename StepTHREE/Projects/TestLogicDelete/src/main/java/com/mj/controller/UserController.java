package com.mj.controller;

import com.mj.po.User;
import com.mj.result.DataJsonVo;
import com.mj.result.JsonVo;
import com.mj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = "用户")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/list")
    @ApiOperation("查询所有")
    public DataJsonVo<List<User>> list() {
        return new DataJsonVo<>(service.list());
    }

    @PostMapping("/save1")
    @ApiOperation("添加或更新")
    public JsonVo save1(@RequestParam User user) {
        JsonVo jsonVo = new JsonVo();
        jsonVo.setMsg(service.saveOrUpdate(user) ? "保存成功" : "保存失败");
        return jsonVo;
    }

    @PostMapping("/save2")
    @ApiOperation("添加或更新")
    public JsonVo save2(@RequestBody User user) { // 让前端传一个User类型的JSON字符串过来
        JsonVo jsonVo = new JsonVo();
        jsonVo.setMsg(service.saveOrUpdate(user) ? "保存成功" : "保存失败");
        return jsonVo;
    }

    @PostMapping("/json")
    @ApiOperation("测试")
    public DataJsonVo<User> json(@RequestBody User user) {
        return new DataJsonVo<>(user);
    }

    @PostMapping("/remove")
    @ApiOperation("删除")
    public JsonVo remove(Long id) {
        JsonVo jsonVo = new JsonVo();
        jsonVo.setMsg(service.removeById(id) ? "删除成功" : "删除失败");
        return jsonVo;
    }
}