package com.demo.vue.web;

import com.demo.common.domain.Result;
import com.demo.vue.service.LoginService;
import com.demo.vue.vo.UserVo;
import lombok.SneakyThrows;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin //跨域
public class LoginWeb {

    @Resource
    private LoginService loginService;

    @Resource
    private HttpSession session;

    @SneakyThrows//代替try-catch
    @RequestMapping("/login")
    public Result login(@RequestBody UserVo userVo) {
        return loginService.login(userVo.getUserName(),userVo.getPwd(),session);
    }

    public static void main(String[] args) {
        System.out.println(SpringVersion.getVersion());
    }
}
