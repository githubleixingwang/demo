package com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: lxw
 * @date: 2023-06-28  10:08
 */
public class DeleteUserEvent extends ApplicationEvent {

    private String userName;
    private String email;

    public DeleteUserEvent(Object source, String userName, String email) {
        super(source);
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
