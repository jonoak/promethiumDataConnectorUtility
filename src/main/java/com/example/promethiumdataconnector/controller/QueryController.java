package com.example.promethiumdataconnector.controller;

import com.example.promethiumdataconnector.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/optimize")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping
    public Map<String, Object> optimizeQuery(@RequestBody String query) {
        return queryService.optimizeQuery(query);
    }
}
