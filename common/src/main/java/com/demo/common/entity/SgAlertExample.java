package com.demo.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgAlertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgAlertExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDevSnIsNull() {
            addCriterion("dev_sn is null");
            return (Criteria) this;
        }

        public Criteria andDevSnIsNotNull() {
            addCriterion("dev_sn is not null");
            return (Criteria) this;
        }

        public Criteria andDevSnEqualTo(String value) {
            addCriterion("dev_sn =", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnNotEqualTo(String value) {
            addCriterion("dev_sn <>", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnGreaterThan(String value) {
            addCriterion("dev_sn >", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnGreaterThanOrEqualTo(String value) {
            addCriterion("dev_sn >=", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnLessThan(String value) {
            addCriterion("dev_sn <", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnLessThanOrEqualTo(String value) {
            addCriterion("dev_sn <=", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnLike(String value) {
            addCriterion("dev_sn like", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnNotLike(String value) {
            addCriterion("dev_sn not like", value, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnIn(List<String> values) {
            addCriterion("dev_sn in", values, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnNotIn(List<String> values) {
            addCriterion("dev_sn not in", values, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnBetween(String value1, String value2) {
            addCriterion("dev_sn between", value1, value2, "devSn");
            return (Criteria) this;
        }

        public Criteria andDevSnNotBetween(String value1, String value2) {
            addCriterion("dev_sn not between", value1, value2, "devSn");
            return (Criteria) this;
        }

        public Criteria andContainerIdIsNull() {
            addCriterion("container_id is null");
            return (Criteria) this;
        }

        public Criteria andContainerIdIsNotNull() {
            addCriterion("container_id is not null");
            return (Criteria) this;
        }

        public Criteria andContainerIdEqualTo(String value) {
            addCriterion("container_id =", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotEqualTo(String value) {
            addCriterion("container_id <>", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdGreaterThan(String value) {
            addCriterion("container_id >", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdGreaterThanOrEqualTo(String value) {
            addCriterion("container_id >=", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdLessThan(String value) {
            addCriterion("container_id <", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdLessThanOrEqualTo(String value) {
            addCriterion("container_id <=", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdLike(String value) {
            addCriterion("container_id like", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotLike(String value) {
            addCriterion("container_id not like", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdIn(List<String> values) {
            addCriterion("container_id in", values, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotIn(List<String> values) {
            addCriterion("container_id not in", values, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdBetween(String value1, String value2) {
            addCriterion("container_id between", value1, value2, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotBetween(String value1, String value2) {
            addCriterion("container_id not between", value1, value2, "containerId");
            return (Criteria) this;
        }

        public Criteria andAlertModelIsNull() {
            addCriterion("alert_model is null");
            return (Criteria) this;
        }

        public Criteria andAlertModelIsNotNull() {
            addCriterion("alert_model is not null");
            return (Criteria) this;
        }

        public Criteria andAlertModelEqualTo(String value) {
            addCriterion("alert_model =", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelNotEqualTo(String value) {
            addCriterion("alert_model <>", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelGreaterThan(String value) {
            addCriterion("alert_model >", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelGreaterThanOrEqualTo(String value) {
            addCriterion("alert_model >=", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelLessThan(String value) {
            addCriterion("alert_model <", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelLessThanOrEqualTo(String value) {
            addCriterion("alert_model <=", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelLike(String value) {
            addCriterion("alert_model like", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelNotLike(String value) {
            addCriterion("alert_model not like", value, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelIn(List<String> values) {
            addCriterion("alert_model in", values, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelNotIn(List<String> values) {
            addCriterion("alert_model not in", values, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelBetween(String value1, String value2) {
            addCriterion("alert_model between", value1, value2, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertModelNotBetween(String value1, String value2) {
            addCriterion("alert_model not between", value1, value2, "alertModel");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNull() {
            addCriterion("alert_time is null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNotNull() {
            addCriterion("alert_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeEqualTo(Date value) {
            addCriterion("alert_time =", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotEqualTo(Date value) {
            addCriterion("alert_time <>", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThan(Date value) {
            addCriterion("alert_time >", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alert_time >=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThan(Date value) {
            addCriterion("alert_time <", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThanOrEqualTo(Date value) {
            addCriterion("alert_time <=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIn(List<Date> values) {
            addCriterion("alert_time in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotIn(List<Date> values) {
            addCriterion("alert_time not in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeBetween(Date value1, Date value2) {
            addCriterion("alert_time between", value1, value2, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotBetween(Date value1, Date value2) {
            addCriterion("alert_time not between", value1, value2, "alertTime");
            return (Criteria) this;
        }

        public Criteria andRamRealIsNull() {
            addCriterion("ram_real is null");
            return (Criteria) this;
        }

        public Criteria andRamRealIsNotNull() {
            addCriterion("ram_real is not null");
            return (Criteria) this;
        }

        public Criteria andRamRealEqualTo(String value) {
            addCriterion("ram_real =", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealNotEqualTo(String value) {
            addCriterion("ram_real <>", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealGreaterThan(String value) {
            addCriterion("ram_real >", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealGreaterThanOrEqualTo(String value) {
            addCriterion("ram_real >=", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealLessThan(String value) {
            addCriterion("ram_real <", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealLessThanOrEqualTo(String value) {
            addCriterion("ram_real <=", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealLike(String value) {
            addCriterion("ram_real like", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealNotLike(String value) {
            addCriterion("ram_real not like", value, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealIn(List<String> values) {
            addCriterion("ram_real in", values, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealNotIn(List<String> values) {
            addCriterion("ram_real not in", values, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealBetween(String value1, String value2) {
            addCriterion("ram_real between", value1, value2, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamRealNotBetween(String value1, String value2) {
            addCriterion("ram_real not between", value1, value2, "ramReal");
            return (Criteria) this;
        }

        public Criteria andRamThresholdIsNull() {
            addCriterion("ram_threshold is null");
            return (Criteria) this;
        }

        public Criteria andRamThresholdIsNotNull() {
            addCriterion("ram_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andRamThresholdEqualTo(String value) {
            addCriterion("ram_threshold =", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdNotEqualTo(String value) {
            addCriterion("ram_threshold <>", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdGreaterThan(String value) {
            addCriterion("ram_threshold >", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("ram_threshold >=", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdLessThan(String value) {
            addCriterion("ram_threshold <", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdLessThanOrEqualTo(String value) {
            addCriterion("ram_threshold <=", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdLike(String value) {
            addCriterion("ram_threshold like", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdNotLike(String value) {
            addCriterion("ram_threshold not like", value, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdIn(List<String> values) {
            addCriterion("ram_threshold in", values, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdNotIn(List<String> values) {
            addCriterion("ram_threshold not in", values, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdBetween(String value1, String value2) {
            addCriterion("ram_threshold between", value1, value2, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andRamThresholdNotBetween(String value1, String value2) {
            addCriterion("ram_threshold not between", value1, value2, "ramThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskRealIsNull() {
            addCriterion("disk_real is null");
            return (Criteria) this;
        }

        public Criteria andDiskRealIsNotNull() {
            addCriterion("disk_real is not null");
            return (Criteria) this;
        }

        public Criteria andDiskRealEqualTo(String value) {
            addCriterion("disk_real =", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealNotEqualTo(String value) {
            addCriterion("disk_real <>", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealGreaterThan(String value) {
            addCriterion("disk_real >", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealGreaterThanOrEqualTo(String value) {
            addCriterion("disk_real >=", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealLessThan(String value) {
            addCriterion("disk_real <", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealLessThanOrEqualTo(String value) {
            addCriterion("disk_real <=", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealLike(String value) {
            addCriterion("disk_real like", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealNotLike(String value) {
            addCriterion("disk_real not like", value, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealIn(List<String> values) {
            addCriterion("disk_real in", values, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealNotIn(List<String> values) {
            addCriterion("disk_real not in", values, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealBetween(String value1, String value2) {
            addCriterion("disk_real between", value1, value2, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskRealNotBetween(String value1, String value2) {
            addCriterion("disk_real not between", value1, value2, "diskReal");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdIsNull() {
            addCriterion("disk_threshold is null");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdIsNotNull() {
            addCriterion("disk_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdEqualTo(String value) {
            addCriterion("disk_threshold =", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdNotEqualTo(String value) {
            addCriterion("disk_threshold <>", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdGreaterThan(String value) {
            addCriterion("disk_threshold >", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("disk_threshold >=", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdLessThan(String value) {
            addCriterion("disk_threshold <", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdLessThanOrEqualTo(String value) {
            addCriterion("disk_threshold <=", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdLike(String value) {
            addCriterion("disk_threshold like", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdNotLike(String value) {
            addCriterion("disk_threshold not like", value, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdIn(List<String> values) {
            addCriterion("disk_threshold in", values, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdNotIn(List<String> values) {
            addCriterion("disk_threshold not in", values, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdBetween(String value1, String value2) {
            addCriterion("disk_threshold between", value1, value2, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andDiskThresholdNotBetween(String value1, String value2) {
            addCriterion("disk_threshold not between", value1, value2, "diskThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuRealIsNull() {
            addCriterion("cpu_real is null");
            return (Criteria) this;
        }

        public Criteria andCpuRealIsNotNull() {
            addCriterion("cpu_real is not null");
            return (Criteria) this;
        }

        public Criteria andCpuRealEqualTo(String value) {
            addCriterion("cpu_real =", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealNotEqualTo(String value) {
            addCriterion("cpu_real <>", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealGreaterThan(String value) {
            addCriterion("cpu_real >", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_real >=", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealLessThan(String value) {
            addCriterion("cpu_real <", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealLessThanOrEqualTo(String value) {
            addCriterion("cpu_real <=", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealLike(String value) {
            addCriterion("cpu_real like", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealNotLike(String value) {
            addCriterion("cpu_real not like", value, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealIn(List<String> values) {
            addCriterion("cpu_real in", values, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealNotIn(List<String> values) {
            addCriterion("cpu_real not in", values, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealBetween(String value1, String value2) {
            addCriterion("cpu_real between", value1, value2, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuRealNotBetween(String value1, String value2) {
            addCriterion("cpu_real not between", value1, value2, "cpuReal");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdIsNull() {
            addCriterion("cpu_threshold is null");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdIsNotNull() {
            addCriterion("cpu_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdEqualTo(String value) {
            addCriterion("cpu_threshold =", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdNotEqualTo(String value) {
            addCriterion("cpu_threshold <>", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdGreaterThan(String value) {
            addCriterion("cpu_threshold >", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_threshold >=", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdLessThan(String value) {
            addCriterion("cpu_threshold <", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdLessThanOrEqualTo(String value) {
            addCriterion("cpu_threshold <=", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdLike(String value) {
            addCriterion("cpu_threshold like", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdNotLike(String value) {
            addCriterion("cpu_threshold not like", value, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdIn(List<String> values) {
            addCriterion("cpu_threshold in", values, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdNotIn(List<String> values) {
            addCriterion("cpu_threshold not in", values, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdBetween(String value1, String value2) {
            addCriterion("cpu_threshold between", value1, value2, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andCpuThresholdNotBetween(String value1, String value2) {
            addCriterion("cpu_threshold not between", value1, value2, "cpuThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealIsNull() {
            addCriterion("temperature_real is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealIsNotNull() {
            addCriterion("temperature_real is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealEqualTo(String value) {
            addCriterion("temperature_real =", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealNotEqualTo(String value) {
            addCriterion("temperature_real <>", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealGreaterThan(String value) {
            addCriterion("temperature_real >", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealGreaterThanOrEqualTo(String value) {
            addCriterion("temperature_real >=", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealLessThan(String value) {
            addCriterion("temperature_real <", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealLessThanOrEqualTo(String value) {
            addCriterion("temperature_real <=", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealLike(String value) {
            addCriterion("temperature_real like", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealNotLike(String value) {
            addCriterion("temperature_real not like", value, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealIn(List<String> values) {
            addCriterion("temperature_real in", values, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealNotIn(List<String> values) {
            addCriterion("temperature_real not in", values, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealBetween(String value1, String value2) {
            addCriterion("temperature_real between", value1, value2, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureRealNotBetween(String value1, String value2) {
            addCriterion("temperature_real not between", value1, value2, "temperatureReal");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIsNull() {
            addCriterion("temperature_threshold is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIsNotNull() {
            addCriterion("temperature_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdEqualTo(String value) {
            addCriterion("temperature_threshold =", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotEqualTo(String value) {
            addCriterion("temperature_threshold <>", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdGreaterThan(String value) {
            addCriterion("temperature_threshold >", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("temperature_threshold >=", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdLessThan(String value) {
            addCriterion("temperature_threshold <", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdLessThanOrEqualTo(String value) {
            addCriterion("temperature_threshold <=", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdLike(String value) {
            addCriterion("temperature_threshold like", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotLike(String value) {
            addCriterion("temperature_threshold not like", value, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdIn(List<String> values) {
            addCriterion("temperature_threshold in", values, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotIn(List<String> values) {
            addCriterion("temperature_threshold not in", values, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdBetween(String value1, String value2) {
            addCriterion("temperature_threshold between", value1, value2, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andTemperatureThresholdNotBetween(String value1, String value2) {
            addCriterion("temperature_threshold not between", value1, value2, "temperatureThreshold");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusIsNull() {
            addCriterion("lostPower_status is null");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusIsNotNull() {
            addCriterion("lostPower_status is not null");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusEqualTo(String value) {
            addCriterion("lostPower_status =", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusNotEqualTo(String value) {
            addCriterion("lostPower_status <>", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusGreaterThan(String value) {
            addCriterion("lostPower_status >", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("lostPower_status >=", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusLessThan(String value) {
            addCriterion("lostPower_status <", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusLessThanOrEqualTo(String value) {
            addCriterion("lostPower_status <=", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusLike(String value) {
            addCriterion("lostPower_status like", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusNotLike(String value) {
            addCriterion("lostPower_status not like", value, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusIn(List<String> values) {
            addCriterion("lostPower_status in", values, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusNotIn(List<String> values) {
            addCriterion("lostPower_status not in", values, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusBetween(String value1, String value2) {
            addCriterion("lostPower_status between", value1, value2, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andLostpowerStatusNotBetween(String value1, String value2) {
            addCriterion("lostPower_status not between", value1, value2, "lostpowerStatus");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andContainerNameIsNull() {
            addCriterion("container_name is null");
            return (Criteria) this;
        }

        public Criteria andContainerNameIsNotNull() {
            addCriterion("container_name is not null");
            return (Criteria) this;
        }

        public Criteria andContainerNameEqualTo(String value) {
            addCriterion("container_name =", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotEqualTo(String value) {
            addCriterion("container_name <>", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameGreaterThan(String value) {
            addCriterion("container_name >", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("container_name >=", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLessThan(String value) {
            addCriterion("container_name <", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLessThanOrEqualTo(String value) {
            addCriterion("container_name <=", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLike(String value) {
            addCriterion("container_name like", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotLike(String value) {
            addCriterion("container_name not like", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameIn(List<String> values) {
            addCriterion("container_name in", values, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotIn(List<String> values) {
            addCriterion("container_name not in", values, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameBetween(String value1, String value2) {
            addCriterion("container_name between", value1, value2, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotBetween(String value1, String value2) {
            addCriterion("container_name not between", value1, value2, "containerName");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusIsNull() {
            addCriterion("topCap_status is null");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusIsNotNull() {
            addCriterion("topCap_status is not null");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusEqualTo(String value) {
            addCriterion("topCap_status =", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusNotEqualTo(String value) {
            addCriterion("topCap_status <>", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusGreaterThan(String value) {
            addCriterion("topCap_status >", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusGreaterThanOrEqualTo(String value) {
            addCriterion("topCap_status >=", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusLessThan(String value) {
            addCriterion("topCap_status <", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusLessThanOrEqualTo(String value) {
            addCriterion("topCap_status <=", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusLike(String value) {
            addCriterion("topCap_status like", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusNotLike(String value) {
            addCriterion("topCap_status not like", value, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusIn(List<String> values) {
            addCriterion("topCap_status in", values, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusNotIn(List<String> values) {
            addCriterion("topCap_status not in", values, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusBetween(String value1, String value2) {
            addCriterion("topCap_status between", value1, value2, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTopcapStatusNotBetween(String value1, String value2) {
            addCriterion("topCap_status not between", value1, value2, "topcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusIsNull() {
            addCriterion("tailCap_status is null");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusIsNotNull() {
            addCriterion("tailCap_status is not null");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusEqualTo(String value) {
            addCriterion("tailCap_status =", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusNotEqualTo(String value) {
            addCriterion("tailCap_status <>", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusGreaterThan(String value) {
            addCriterion("tailCap_status >", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusGreaterThanOrEqualTo(String value) {
            addCriterion("tailCap_status >=", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusLessThan(String value) {
            addCriterion("tailCap_status <", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusLessThanOrEqualTo(String value) {
            addCriterion("tailCap_status <=", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusLike(String value) {
            addCriterion("tailCap_status like", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusNotLike(String value) {
            addCriterion("tailCap_status not like", value, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusIn(List<String> values) {
            addCriterion("tailCap_status in", values, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusNotIn(List<String> values) {
            addCriterion("tailCap_status not in", values, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusBetween(String value1, String value2) {
            addCriterion("tailCap_status between", value1, value2, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTailcapStatusNotBetween(String value1, String value2) {
            addCriterion("tailCap_status not between", value1, value2, "tailcapStatus");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeIsNull() {
            addCriterion("temperature_type is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeIsNotNull() {
            addCriterion("temperature_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeEqualTo(String value) {
            addCriterion("temperature_type =", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeNotEqualTo(String value) {
            addCriterion("temperature_type <>", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeGreaterThan(String value) {
            addCriterion("temperature_type >", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeGreaterThanOrEqualTo(String value) {
            addCriterion("temperature_type >=", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeLessThan(String value) {
            addCriterion("temperature_type <", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeLessThanOrEqualTo(String value) {
            addCriterion("temperature_type <=", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeLike(String value) {
            addCriterion("temperature_type like", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeNotLike(String value) {
            addCriterion("temperature_type not like", value, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeIn(List<String> values) {
            addCriterion("temperature_type in", values, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeNotIn(List<String> values) {
            addCriterion("temperature_type not in", values, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeBetween(String value1, String value2) {
            addCriterion("temperature_type between", value1, value2, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andTemperatureTypeNotBetween(String value1, String value2) {
            addCriterion("temperature_type not between", value1, value2, "temperatureType");
            return (Criteria) this;
        }

        public Criteria andCpuRateIsNull() {
            addCriterion("cpu_rate is null");
            return (Criteria) this;
        }

        public Criteria andCpuRateIsNotNull() {
            addCriterion("cpu_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCpuRateEqualTo(Integer value) {
            addCriterion("cpu_rate =", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateNotEqualTo(Integer value) {
            addCriterion("cpu_rate <>", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateGreaterThan(Integer value) {
            addCriterion("cpu_rate >", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpu_rate >=", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateLessThan(Integer value) {
            addCriterion("cpu_rate <", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateLessThanOrEqualTo(Integer value) {
            addCriterion("cpu_rate <=", value, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateIn(List<Integer> values) {
            addCriterion("cpu_rate in", values, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateNotIn(List<Integer> values) {
            addCriterion("cpu_rate not in", values, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateBetween(Integer value1, Integer value2) {
            addCriterion("cpu_rate between", value1, value2, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andCpuRateNotBetween(Integer value1, Integer value2) {
            addCriterion("cpu_rate not between", value1, value2, "cpuRate");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyIsNull() {
            addCriterion("mem_used_phy is null");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyIsNotNull() {
            addCriterion("mem_used_phy is not null");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyEqualTo(Integer value) {
            addCriterion("mem_used_phy =", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyNotEqualTo(Integer value) {
            addCriterion("mem_used_phy <>", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyGreaterThan(Integer value) {
            addCriterion("mem_used_phy >", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyGreaterThanOrEqualTo(Integer value) {
            addCriterion("mem_used_phy >=", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyLessThan(Integer value) {
            addCriterion("mem_used_phy <", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyLessThanOrEqualTo(Integer value) {
            addCriterion("mem_used_phy <=", value, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyIn(List<Integer> values) {
            addCriterion("mem_used_phy in", values, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyNotIn(List<Integer> values) {
            addCriterion("mem_used_phy not in", values, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyBetween(Integer value1, Integer value2) {
            addCriterion("mem_used_phy between", value1, value2, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedPhyNotBetween(Integer value1, Integer value2) {
            addCriterion("mem_used_phy not between", value1, value2, "memUsedPhy");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtIsNull() {
            addCriterion("mem_used_virt is null");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtIsNotNull() {
            addCriterion("mem_used_virt is not null");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtEqualTo(Integer value) {
            addCriterion("mem_used_virt =", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtNotEqualTo(Integer value) {
            addCriterion("mem_used_virt <>", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtGreaterThan(Integer value) {
            addCriterion("mem_used_virt >", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtGreaterThanOrEqualTo(Integer value) {
            addCriterion("mem_used_virt >=", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtLessThan(Integer value) {
            addCriterion("mem_used_virt <", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtLessThanOrEqualTo(Integer value) {
            addCriterion("mem_used_virt <=", value, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtIn(List<Integer> values) {
            addCriterion("mem_used_virt in", values, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtNotIn(List<Integer> values) {
            addCriterion("mem_used_virt not in", values, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtBetween(Integer value1, Integer value2) {
            addCriterion("mem_used_virt between", value1, value2, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andMemUsedVirtNotBetween(Integer value1, Integer value2) {
            addCriterion("mem_used_virt not between", value1, value2, "memUsedVirt");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIsNull() {
            addCriterion("disk_used is null");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIsNotNull() {
            addCriterion("disk_used is not null");
            return (Criteria) this;
        }

        public Criteria andDiskUsedEqualTo(Integer value) {
            addCriterion("disk_used =", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotEqualTo(Integer value) {
            addCriterion("disk_used <>", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedGreaterThan(Integer value) {
            addCriterion("disk_used >", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("disk_used >=", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedLessThan(Integer value) {
            addCriterion("disk_used <", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedLessThanOrEqualTo(Integer value) {
            addCriterion("disk_used <=", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIn(List<Integer> values) {
            addCriterion("disk_used in", values, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotIn(List<Integer> values) {
            addCriterion("disk_used not in", values, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedBetween(Integer value1, Integer value2) {
            addCriterion("disk_used between", value1, value2, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("disk_used not between", value1, value2, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andTempValueIsNull() {
            addCriterion("temp_value is null");
            return (Criteria) this;
        }

        public Criteria andTempValueIsNotNull() {
            addCriterion("temp_value is not null");
            return (Criteria) this;
        }

        public Criteria andTempValueEqualTo(Integer value) {
            addCriterion("temp_value =", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueNotEqualTo(Integer value) {
            addCriterion("temp_value <>", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueGreaterThan(Integer value) {
            addCriterion("temp_value >", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_value >=", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueLessThan(Integer value) {
            addCriterion("temp_value <", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueLessThanOrEqualTo(Integer value) {
            addCriterion("temp_value <=", value, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueIn(List<Integer> values) {
            addCriterion("temp_value in", values, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueNotIn(List<Integer> values) {
            addCriterion("temp_value not in", values, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueBetween(Integer value1, Integer value2) {
            addCriterion("temp_value between", value1, value2, "tempValue");
            return (Criteria) this;
        }

        public Criteria andTempValueNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_value not between", value1, value2, "tempValue");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameIsNull() {
            addCriterion("link_state_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameIsNotNull() {
            addCriterion("link_state_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameEqualTo(String value) {
            addCriterion("link_state_name =", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameNotEqualTo(String value) {
            addCriterion("link_state_name <>", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameGreaterThan(String value) {
            addCriterion("link_state_name >", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_state_name >=", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameLessThan(String value) {
            addCriterion("link_state_name <", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameLessThanOrEqualTo(String value) {
            addCriterion("link_state_name <=", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameLike(String value) {
            addCriterion("link_state_name like", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameNotLike(String value) {
            addCriterion("link_state_name not like", value, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameIn(List<String> values) {
            addCriterion("link_state_name in", values, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameNotIn(List<String> values) {
            addCriterion("link_state_name not in", values, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameBetween(String value1, String value2) {
            addCriterion("link_state_name between", value1, value2, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateNameNotBetween(String value1, String value2) {
            addCriterion("link_state_name not between", value1, value2, "linkStateName");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusIsNull() {
            addCriterion("link_state_status is null");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusIsNotNull() {
            addCriterion("link_state_status is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusEqualTo(String value) {
            addCriterion("link_state_status =", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusNotEqualTo(String value) {
            addCriterion("link_state_status <>", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusGreaterThan(String value) {
            addCriterion("link_state_status >", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("link_state_status >=", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusLessThan(String value) {
            addCriterion("link_state_status <", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusLessThanOrEqualTo(String value) {
            addCriterion("link_state_status <=", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusLike(String value) {
            addCriterion("link_state_status like", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusNotLike(String value) {
            addCriterion("link_state_status not like", value, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusIn(List<String> values) {
            addCriterion("link_state_status in", values, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusNotIn(List<String> values) {
            addCriterion("link_state_status not in", values, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusBetween(String value1, String value2) {
            addCriterion("link_state_status between", value1, value2, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStateStatusNotBetween(String value1, String value2) {
            addCriterion("link_state_status not between", value1, value2, "linkStateStatus");
            return (Criteria) this;
        }

        public Criteria andEventIsNull() {
            addCriterion("event is null");
            return (Criteria) this;
        }

        public Criteria andEventIsNotNull() {
            addCriterion("event is not null");
            return (Criteria) this;
        }

        public Criteria andEventEqualTo(String value) {
            addCriterion("event =", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotEqualTo(String value) {
            addCriterion("event <>", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThan(String value) {
            addCriterion("event >", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThanOrEqualTo(String value) {
            addCriterion("event >=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThan(String value) {
            addCriterion("event <", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThanOrEqualTo(String value) {
            addCriterion("event <=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLike(String value) {
            addCriterion("event like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotLike(String value) {
            addCriterion("event not like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventIn(List<String> values) {
            addCriterion("event in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotIn(List<String> values) {
            addCriterion("event not in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventBetween(String value1, String value2) {
            addCriterion("event between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotBetween(String value1, String value2) {
            addCriterion("event not between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}