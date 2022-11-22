package com.demo.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BugInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BugInfoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBugTagIsNull() {
            addCriterion("bug_tag is null");
            return (Criteria) this;
        }

        public Criteria andBugTagIsNotNull() {
            addCriterion("bug_tag is not null");
            return (Criteria) this;
        }

        public Criteria andBugTagEqualTo(String value) {
            addCriterion("bug_tag =", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagNotEqualTo(String value) {
            addCriterion("bug_tag <>", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagGreaterThan(String value) {
            addCriterion("bug_tag >", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagGreaterThanOrEqualTo(String value) {
            addCriterion("bug_tag >=", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagLessThan(String value) {
            addCriterion("bug_tag <", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagLessThanOrEqualTo(String value) {
            addCriterion("bug_tag <=", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagLike(String value) {
            addCriterion("bug_tag like", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagNotLike(String value) {
            addCriterion("bug_tag not like", value, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagIn(List<String> values) {
            addCriterion("bug_tag in", values, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagNotIn(List<String> values) {
            addCriterion("bug_tag not in", values, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagBetween(String value1, String value2) {
            addCriterion("bug_tag between", value1, value2, "bugTag");
            return (Criteria) this;
        }

        public Criteria andBugTagNotBetween(String value1, String value2) {
            addCriterion("bug_tag not between", value1, value2, "bugTag");
            return (Criteria) this;
        }

        public Criteria andAscrProjectIsNull() {
            addCriterion("ascr_project is null");
            return (Criteria) this;
        }

        public Criteria andAscrProjectIsNotNull() {
            addCriterion("ascr_project is not null");
            return (Criteria) this;
        }

        public Criteria andAscrProjectEqualTo(String value) {
            addCriterion("ascr_project =", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectNotEqualTo(String value) {
            addCriterion("ascr_project <>", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectGreaterThan(String value) {
            addCriterion("ascr_project >", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectGreaterThanOrEqualTo(String value) {
            addCriterion("ascr_project >=", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectLessThan(String value) {
            addCriterion("ascr_project <", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectLessThanOrEqualTo(String value) {
            addCriterion("ascr_project <=", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectLike(String value) {
            addCriterion("ascr_project like", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectNotLike(String value) {
            addCriterion("ascr_project not like", value, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectIn(List<String> values) {
            addCriterion("ascr_project in", values, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectNotIn(List<String> values) {
            addCriterion("ascr_project not in", values, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectBetween(String value1, String value2) {
            addCriterion("ascr_project between", value1, value2, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andAscrProjectNotBetween(String value1, String value2) {
            addCriterion("ascr_project not between", value1, value2, "ascrProject");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andBugLevelIsNull() {
            addCriterion("bug_level is null");
            return (Criteria) this;
        }

        public Criteria andBugLevelIsNotNull() {
            addCriterion("bug_level is not null");
            return (Criteria) this;
        }

        public Criteria andBugLevelEqualTo(String value) {
            addCriterion("bug_level =", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotEqualTo(String value) {
            addCriterion("bug_level <>", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelGreaterThan(String value) {
            addCriterion("bug_level >", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelGreaterThanOrEqualTo(String value) {
            addCriterion("bug_level >=", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelLessThan(String value) {
            addCriterion("bug_level <", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelLessThanOrEqualTo(String value) {
            addCriterion("bug_level <=", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelLike(String value) {
            addCriterion("bug_level like", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotLike(String value) {
            addCriterion("bug_level not like", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelIn(List<String> values) {
            addCriterion("bug_level in", values, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotIn(List<String> values) {
            addCriterion("bug_level not in", values, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelBetween(String value1, String value2) {
            addCriterion("bug_level between", value1, value2, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotBetween(String value1, String value2) {
            addCriterion("bug_level not between", value1, value2, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andBugStateIsNull() {
            addCriterion("bug_state is null");
            return (Criteria) this;
        }

        public Criteria andBugStateIsNotNull() {
            addCriterion("bug_state is not null");
            return (Criteria) this;
        }

        public Criteria andBugStateEqualTo(String value) {
            addCriterion("bug_state =", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateNotEqualTo(String value) {
            addCriterion("bug_state <>", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateGreaterThan(String value) {
            addCriterion("bug_state >", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateGreaterThanOrEqualTo(String value) {
            addCriterion("bug_state >=", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateLessThan(String value) {
            addCriterion("bug_state <", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateLessThanOrEqualTo(String value) {
            addCriterion("bug_state <=", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateLike(String value) {
            addCriterion("bug_state like", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateNotLike(String value) {
            addCriterion("bug_state not like", value, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateIn(List<String> values) {
            addCriterion("bug_state in", values, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateNotIn(List<String> values) {
            addCriterion("bug_state not in", values, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateBetween(String value1, String value2) {
            addCriterion("bug_state between", value1, value2, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugStateNotBetween(String value1, String value2) {
            addCriterion("bug_state not between", value1, value2, "bugState");
            return (Criteria) this;
        }

        public Criteria andBugConfirmIsNull() {
            addCriterion("bug_confirm is null");
            return (Criteria) this;
        }

        public Criteria andBugConfirmIsNotNull() {
            addCriterion("bug_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andBugConfirmEqualTo(String value) {
            addCriterion("bug_confirm =", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmNotEqualTo(String value) {
            addCriterion("bug_confirm <>", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmGreaterThan(String value) {
            addCriterion("bug_confirm >", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmGreaterThanOrEqualTo(String value) {
            addCriterion("bug_confirm >=", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmLessThan(String value) {
            addCriterion("bug_confirm <", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmLessThanOrEqualTo(String value) {
            addCriterion("bug_confirm <=", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmLike(String value) {
            addCriterion("bug_confirm like", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmNotLike(String value) {
            addCriterion("bug_confirm not like", value, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmIn(List<String> values) {
            addCriterion("bug_confirm in", values, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmNotIn(List<String> values) {
            addCriterion("bug_confirm not in", values, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmBetween(String value1, String value2) {
            addCriterion("bug_confirm between", value1, value2, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugConfirmNotBetween(String value1, String value2) {
            addCriterion("bug_confirm not between", value1, value2, "bugConfirm");
            return (Criteria) this;
        }

        public Criteria andBugDescIsNull() {
            addCriterion("bug_desc is null");
            return (Criteria) this;
        }

        public Criteria andBugDescIsNotNull() {
            addCriterion("bug_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBugDescEqualTo(String value) {
            addCriterion("bug_desc =", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotEqualTo(String value) {
            addCriterion("bug_desc <>", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescGreaterThan(String value) {
            addCriterion("bug_desc >", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescGreaterThanOrEqualTo(String value) {
            addCriterion("bug_desc >=", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLessThan(String value) {
            addCriterion("bug_desc <", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLessThanOrEqualTo(String value) {
            addCriterion("bug_desc <=", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLike(String value) {
            addCriterion("bug_desc like", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotLike(String value) {
            addCriterion("bug_desc not like", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescIn(List<String> values) {
            addCriterion("bug_desc in", values, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotIn(List<String> values) {
            addCriterion("bug_desc not in", values, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescBetween(String value1, String value2) {
            addCriterion("bug_desc between", value1, value2, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotBetween(String value1, String value2) {
            addCriterion("bug_desc not between", value1, value2, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlIsNull() {
            addCriterion("bug_desc_url is null");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlIsNotNull() {
            addCriterion("bug_desc_url is not null");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlEqualTo(String value) {
            addCriterion("bug_desc_url =", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlNotEqualTo(String value) {
            addCriterion("bug_desc_url <>", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlGreaterThan(String value) {
            addCriterion("bug_desc_url >", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bug_desc_url >=", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlLessThan(String value) {
            addCriterion("bug_desc_url <", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlLessThanOrEqualTo(String value) {
            addCriterion("bug_desc_url <=", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlLike(String value) {
            addCriterion("bug_desc_url like", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlNotLike(String value) {
            addCriterion("bug_desc_url not like", value, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlIn(List<String> values) {
            addCriterion("bug_desc_url in", values, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlNotIn(List<String> values) {
            addCriterion("bug_desc_url not in", values, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlBetween(String value1, String value2) {
            addCriterion("bug_desc_url between", value1, value2, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugDescUrlNotBetween(String value1, String value2) {
            addCriterion("bug_desc_url not between", value1, value2, "bugDescUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanIsNull() {
            addCriterion("bug_solve_plan is null");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanIsNotNull() {
            addCriterion("bug_solve_plan is not null");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanEqualTo(String value) {
            addCriterion("bug_solve_plan =", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanNotEqualTo(String value) {
            addCriterion("bug_solve_plan <>", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanGreaterThan(String value) {
            addCriterion("bug_solve_plan >", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanGreaterThanOrEqualTo(String value) {
            addCriterion("bug_solve_plan >=", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanLessThan(String value) {
            addCriterion("bug_solve_plan <", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanLessThanOrEqualTo(String value) {
            addCriterion("bug_solve_plan <=", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanLike(String value) {
            addCriterion("bug_solve_plan like", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanNotLike(String value) {
            addCriterion("bug_solve_plan not like", value, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanIn(List<String> values) {
            addCriterion("bug_solve_plan in", values, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanNotIn(List<String> values) {
            addCriterion("bug_solve_plan not in", values, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanBetween(String value1, String value2) {
            addCriterion("bug_solve_plan between", value1, value2, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanNotBetween(String value1, String value2) {
            addCriterion("bug_solve_plan not between", value1, value2, "bugSolvePlan");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlIsNull() {
            addCriterion("bug_solve_plan_url is null");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlIsNotNull() {
            addCriterion("bug_solve_plan_url is not null");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlEqualTo(String value) {
            addCriterion("bug_solve_plan_url =", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlNotEqualTo(String value) {
            addCriterion("bug_solve_plan_url <>", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlGreaterThan(String value) {
            addCriterion("bug_solve_plan_url >", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bug_solve_plan_url >=", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlLessThan(String value) {
            addCriterion("bug_solve_plan_url <", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlLessThanOrEqualTo(String value) {
            addCriterion("bug_solve_plan_url <=", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlLike(String value) {
            addCriterion("bug_solve_plan_url like", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlNotLike(String value) {
            addCriterion("bug_solve_plan_url not like", value, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlIn(List<String> values) {
            addCriterion("bug_solve_plan_url in", values, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlNotIn(List<String> values) {
            addCriterion("bug_solve_plan_url not in", values, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlBetween(String value1, String value2) {
            addCriterion("bug_solve_plan_url between", value1, value2, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andBugSolvePlanUrlNotBetween(String value1, String value2) {
            addCriterion("bug_solve_plan_url not between", value1, value2, "bugSolvePlanUrl");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterionForJDBCDate("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterionForJDBCDate("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterionForJDBCDate("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterionForJDBCDate("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterionForJDBCDate("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterionForJDBCDate("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterionForJDBCDate("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterionForJDBCDate("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterionForJDBCDate("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterionForJDBCDate("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterionForJDBCDate("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterionForJDBCDate("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updated not between", value1, value2, "updated");
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