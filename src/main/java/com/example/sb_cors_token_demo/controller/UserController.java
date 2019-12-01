package com.example.sb_cors_token_demo.controller;

import com.example.sb_cors_token_demo.model.User;
import com.example.sb_cors_token_demo.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController{
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String,Object> para) throws JsonProcessingException {
        String username=(String)para.get("username");
        String password=(String)para.get("password");
        String token= TokenUtil.sign(new User(username,password));
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("token",token);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestBody Map<String,Object> para) throws JsonProcessingException {
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("data","data");
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    }
}
