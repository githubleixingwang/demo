package com.demo.vue.service;

import com.demo.common.domain.Result;

import javax.servlet.http.HttpSession;

public interface LoginService {
    Result login(String userName, String pad, HttpSession session);
}
