package com.demo.test.scope;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS) //多例 + 动态代理
public class ScopeB {
}
