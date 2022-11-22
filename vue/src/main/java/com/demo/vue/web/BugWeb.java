package com.demo.vue.web;

import com.demo.common.domain.Result;
import com.demo.common.entity.BugInfo;
import com.demo.vue.service.BugService;
import com.demo.vue.vo.BugVo;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bug")
@CrossOrigin //跨域
public class BugWeb {

    @Resource
    private BugService service;

    @SneakyThrows//代替try-catch
    @RequestMapping("/queryList")
    public PageInfo<BugInfo> queryList() {
         return service.queryListPage();
    }

    @SneakyThrows//代替try-catch
    @RequestMapping("/save")
    public Result save(BugVo vo) {
        return service.save(vo);
    }

}
