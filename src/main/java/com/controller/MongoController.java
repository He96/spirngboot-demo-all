package com.controller;

import com.entity.MongoDoc;
import com.service.MongoService;
import com.util.AllowPass;
import com.util.ResultWarp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongo/")
public class MongoController {
   @Autowired
   private MongoService mongoService;

    @AllowPass
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultWarp<MongoDoc> get(@PathVariable("id") String id) {
        MongoDoc result = mongoService.get(id);
        return new ResultWarp<>(1, "获取成功", result);
    }

}
