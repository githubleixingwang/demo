package com.demo.vue.service;

import com.demo.common.domain.Result;
import com.demo.common.entity.BugInfo;
import com.demo.vue.vo.BugVo;
import com.github.pagehelper.PageInfo;

public interface BugService {

     PageInfo<BugInfo> queryListPage();

     Result save(BugVo vo);
}
