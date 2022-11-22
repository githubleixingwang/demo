package com.demo.vue.service;

import com.demo.common.domain.Result;
import com.demo.common.entity.BugInfo;
import com.demo.common.entity.BugInfoExample;
import com.demo.common.mapper.BugInfoMapper;
import com.demo.vue.dao.BugMapper;
import com.demo.vue.vo.BugVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("bugService")
public class BugServiceImpl implements BugService {

    @Resource
    private BugMapper bugMapper;

    @Resource
    private HttpSession session;

    @Resource
    private BugInfoMapper bugInfoMapper;

    @Override
    public PageInfo<BugInfo> queryListPage() {
        PageInfo<BugInfo> pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(() -> queryList());
        return pageInfo;
    }

    public List<BugInfo> queryList() {
        List<BugInfo> bugInfos =  bugMapper.queryList();
        return bugInfos;
    }

    @Override
    public Result save(BugVo vo) {
        BugInfo bugInfo = new BugInfo();
        BeanUtils.copyProperties(vo,bugInfo);
        bugInfo.setBugState("01");
        bugInfo.setBugConfirm("02");
        bugInfo.setCreateUser(Optional.ofNullable(session.getAttribute("userName")).orElse("").toString());
        bugInfo.setCreated(new Date());
        //BugInfo bugInfo1 = bugInfoMapper.selectByPrimaryKey(1L);
        BugInfoExample bugInfoExample = new BugInfoExample();
        BugInfoExample.Criteria criteria = bugInfoExample.createCriteria();
        criteria.andIdEqualTo(1L);
        List<BugInfo> bugInfos = bugInfoMapper.selectByExample(bugInfoExample);
        bugInfoMapper.insert(bugInfo);
        return new Result();
    }


}
