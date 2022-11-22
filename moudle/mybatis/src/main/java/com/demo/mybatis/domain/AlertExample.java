package com.demo.mybatis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlertExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEsnIsNull() {
            addCriterion("esn is null");
            return (Criteria) this;
        }

        public Criteria andEsnIsNotNull() {
            addCriterion("esn is not null");
            return (Criteria) this;
        }

        public Criteria andEsnEqualTo(String value) {
            addCriterion("esn =", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnNotEqualTo(String value) {
            addCriterion("esn <>", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnGreaterThan(String value) {
            addCriterion("esn >", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnGreaterThanOrEqualTo(String value) {
            addCriterion("esn >=", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnLessThan(String value) {
            addCriterion("esn <", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnLessThanOrEqualTo(String value) {
            addCriterion("esn <=", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnLike(String value) {
            addCriterion("esn like", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnNotLike(String value) {
            addCriterion("esn not like", value, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnIn(List<String> values) {
            addCriterion("esn in", values, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnNotIn(List<String> values) {
            addCriterion("esn not in", values, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnBetween(String value1, String value2) {
            addCriterion("esn between", value1, value2, "esn");
            return (Criteria) this;
        }

        public Criteria andEsnNotBetween(String value1, String value2) {
            addCriterion("esn not between", value1, value2, "esn");
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

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
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