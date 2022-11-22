package com.demo.common.entity;

import java.util.Date;

public class SgAlert {
    private Long id;

    private String devSn;

    private String containerId;

    private String alertModel;

    private Date alertTime;

    private String ramReal;

    private String ramThreshold;

    private String diskReal;

    private String diskThreshold;

    private String cpuReal;

    private String cpuThreshold;

    private String temperatureReal;

    private String temperatureThreshold;

    private String lostpowerStatus;

    private String rank;

    private String appName;

    private String containerName;

    private String topcapStatus;

    private String tailcapStatus;

    private String temperatureType;

    private Integer cpuRate;

    private Integer memUsedPhy;

    private Integer memUsedVirt;

    private Integer diskUsed;

    private Integer tempValue;

    private String linkStateName;

    private String linkStateStatus;

    private String event;

    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevSn() {
        return devSn;
    }

    public void setDevSn(String devSn) {
        this.devSn = devSn == null ? null : devSn.trim();
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId == null ? null : containerId.trim();
    }

    public String getAlertModel() {
        return alertModel;
    }

    public void setAlertModel(String alertModel) {
        this.alertModel = alertModel == null ? null : alertModel.trim();
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public String getRamReal() {
        return ramReal;
    }

    public void setRamReal(String ramReal) {
        this.ramReal = ramReal == null ? null : ramReal.trim();
    }

    public String getRamThreshold() {
        return ramThreshold;
    }

    public void setRamThreshold(String ramThreshold) {
        this.ramThreshold = ramThreshold == null ? null : ramThreshold.trim();
    }

    public String getDiskReal() {
        return diskReal;
    }

    public void setDiskReal(String diskReal) {
        this.diskReal = diskReal == null ? null : diskReal.trim();
    }

    public String getDiskThreshold() {
        return diskThreshold;
    }

    public void setDiskThreshold(String diskThreshold) {
        this.diskThreshold = diskThreshold == null ? null : diskThreshold.trim();
    }

    public String getCpuReal() {
        return cpuReal;
    }

    public void setCpuReal(String cpuReal) {
        this.cpuReal = cpuReal == null ? null : cpuReal.trim();
    }

    public String getCpuThreshold() {
        return cpuThreshold;
    }

    public void setCpuThreshold(String cpuThreshold) {
        this.cpuThreshold = cpuThreshold == null ? null : cpuThreshold.trim();
    }

    public String getTemperatureReal() {
        return temperatureReal;
    }

    public void setTemperatureReal(String temperatureReal) {
        this.temperatureReal = temperatureReal == null ? null : temperatureReal.trim();
    }

    public String getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public void setTemperatureThreshold(String temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold == null ? null : temperatureThreshold.trim();
    }

    public String getLostpowerStatus() {
        return lostpowerStatus;
    }

    public void setLostpowerStatus(String lostpowerStatus) {
        this.lostpowerStatus = lostpowerStatus == null ? null : lostpowerStatus.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName == null ? null : containerName.trim();
    }

    public String getTopcapStatus() {
        return topcapStatus;
    }

    public void setTopcapStatus(String topcapStatus) {
        this.topcapStatus = topcapStatus == null ? null : topcapStatus.trim();
    }

    public String getTailcapStatus() {
        return tailcapStatus;
    }

    public void setTailcapStatus(String tailcapStatus) {
        this.tailcapStatus = tailcapStatus == null ? null : tailcapStatus.trim();
    }

    public String getTemperatureType() {
        return temperatureType;
    }

    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType == null ? null : temperatureType.trim();
    }

    public Integer getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(Integer cpuRate) {
        this.cpuRate = cpuRate;
    }

    public Integer getMemUsedPhy() {
        return memUsedPhy;
    }

    public void setMemUsedPhy(Integer memUsedPhy) {
        this.memUsedPhy = memUsedPhy;
    }

    public Integer getMemUsedVirt() {
        return memUsedVirt;
    }

    public void setMemUsedVirt(Integer memUsedVirt) {
        this.memUsedVirt = memUsedVirt;
    }

    public Integer getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Integer diskUsed) {
        this.diskUsed = diskUsed;
    }

    public Integer getTempValue() {
        return tempValue;
    }

    public void setTempValue(Integer tempValue) {
        this.tempValue = tempValue;
    }

    public String getLinkStateName() {
        return linkStateName;
    }

    public void setLinkStateName(String linkStateName) {
        this.linkStateName = linkStateName == null ? null : linkStateName.trim();
    }

    public String getLinkStateStatus() {
        return linkStateStatus;
    }

    public void setLinkStateStatus(String linkStateStatus) {
        this.linkStateStatus = linkStateStatus == null ? null : linkStateStatus.trim();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}