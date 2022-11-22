package com.demo.vue.service;

import com.demo.common.domain.Result;
import com.demo.vue.dao.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Resource
    private LoginMapper loginMapper;
    @Override
    public Result login(String userName, String pad, HttpSession session) {
        /*验证用户信息合法性*/
        Boolean isVerif = loginMapper.verUserInfo(userName, pad);
        if (!isVerif  ) {
            return new Result("用户名或密码错误");
        }
        /*用户名存入session*/
        session.setAttribute("userName",userName);
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        //jackson
        // ObjectMapper objectMapper = new ObjectMapper();
        map.put("userName", userName);
        result.setMap(map);
        return result;
    }
}
