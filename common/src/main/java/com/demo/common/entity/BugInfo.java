package com.demo.common.entity;

import java.util.Date;

public class BugInfo {
    private Long id;

    private String bugTag;

    private String ascrProject;

    private String principal;

    private String bugLevel;

    private Date endTime;

    private String bugState;

    private String bugConfirm;

    private String bugDesc;

    private String bugDescUrl;

    private String bugSolvePlan;

    private String bugSolvePlanUrl;

    private String createUser;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBugTag() {
        return bugTag;
    }

    public void setBugTag(String bugTag) {
        this.bugTag = bugTag == null ? null : bugTag.trim();
    }

    public String getAscrProject() {
        return ascrProject;
    }

    public void setAscrProject(String ascrProject) {
        this.ascrProject = ascrProject == null ? null : ascrProject.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(String bugLevel) {
        this.bugLevel = bugLevel == null ? null : bugLevel.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBugState() {
        return bugState;
    }

    public void setBugState(String bugState) {
        this.bugState = bugState == null ? null : bugState.trim();
    }

    public String getBugConfirm() {
        return bugConfirm;
    }

    public void setBugConfirm(String bugConfirm) {
        this.bugConfirm = bugConfirm == null ? null : bugConfirm.trim();
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public void setBugDesc(String bugDesc) {
        this.bugDesc = bugDesc == null ? null : bugDesc.trim();
    }

    public String getBugDescUrl() {
        return bugDescUrl;
    }

    public void setBugDescUrl(String bugDescUrl) {
        this.bugDescUrl = bugDescUrl == null ? null : bugDescUrl.trim();
    }

    public String getBugSolvePlan() {
        return bugSolvePlan;
    }

    public void setBugSolvePlan(String bugSolvePlan) {
        this.bugSolvePlan = bugSolvePlan == null ? null : bugSolvePlan.trim();
    }

    public String getBugSolvePlanUrl() {
        return bugSolvePlanUrl;
    }

    public void setBugSolvePlanUrl(String bugSolvePlanUrl) {
        this.bugSolvePlanUrl = bugSolvePlanUrl == null ? null : bugSolvePlanUrl.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}