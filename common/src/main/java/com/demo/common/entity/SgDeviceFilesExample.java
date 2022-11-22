package com.demo.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgDeviceFilesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgDeviceFilesExample() {
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

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIsNull() {
            addCriterion("device_model is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIsNotNull() {
            addCriterion("device_model is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelEqualTo(String value) {
            addCriterion("device_model =", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotEqualTo(String value) {
            addCriterion("device_model <>", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThan(String value) {
            addCriterion("device_model >", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThanOrEqualTo(String value) {
            addCriterion("device_model >=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThan(String value) {
            addCriterion("device_model <", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThanOrEqualTo(String value) {
            addCriterion("device_model <=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLike(String value) {
            addCriterion("device_model like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotLike(String value) {
            addCriterion("device_model not like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIn(List<String> values) {
            addCriterion("device_model in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotIn(List<String> values) {
            addCriterion("device_model not in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelBetween(String value1, String value2) {
            addCriterion("device_model between", value1, value2, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotBetween(String value1, String value2) {
            addCriterion("device_model not between", value1, value2, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmIsNull() {
            addCriterion("device_firm is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmIsNotNull() {
            addCriterion("device_firm is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmEqualTo(String value) {
            addCriterion("device_firm =", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotEqualTo(String value) {
            addCriterion("device_firm <>", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmGreaterThan(String value) {
            addCriterion("device_firm >", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmGreaterThanOrEqualTo(String value) {
            addCriterion("device_firm >=", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLessThan(String value) {
            addCriterion("device_firm <", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLessThanOrEqualTo(String value) {
            addCriterion("device_firm <=", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmLike(String value) {
            addCriterion("device_firm like", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotLike(String value) {
            addCriterion("device_firm not like", value, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmIn(List<String> values) {
            addCriterion("device_firm in", values, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotIn(List<String> values) {
            addCriterion("device_firm not in", values, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmBetween(String value1, String value2) {
            addCriterion("device_firm between", value1, value2, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andDeviceFirmNotBetween(String value1, String value2) {
            addCriterion("device_firm not between", value1, value2, "deviceFirm");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIsNull() {
            addCriterion("business_system is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIsNotNull() {
            addCriterion("business_system is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemEqualTo(String value) {
            addCriterion("business_system =", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNotEqualTo(String value) {
            addCriterion("business_system <>", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemGreaterThan(String value) {
            addCriterion("business_system >", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemGreaterThanOrEqualTo(String value) {
            addCriterion("business_system >=", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemLessThan(String value) {
            addCriterion("business_system <", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemLessThanOrEqualTo(String value) {
            addCriterion("business_system <=", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemLike(String value) {
            addCriterion("business_system like", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNotLike(String value) {
            addCriterion("business_system not like", value, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIn(List<String> values) {
            addCriterion("business_system in", values, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNotIn(List<String> values) {
            addCriterion("business_system not in", values, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemBetween(String value1, String value2) {
            addCriterion("business_system between", value1, value2, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNotBetween(String value1, String value2) {
            addCriterion("business_system not between", value1, value2, "businessSystem");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIsNull() {
            addCriterion("communication_type is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIsNotNull() {
            addCriterion("communication_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeEqualTo(String value) {
            addCriterion("communication_type =", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotEqualTo(String value) {
            addCriterion("communication_type <>", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeGreaterThan(String value) {
            addCriterion("communication_type >", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("communication_type >=", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeLessThan(String value) {
            addCriterion("communication_type <", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeLessThanOrEqualTo(String value) {
            addCriterion("communication_type <=", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeLike(String value) {
            addCriterion("communication_type like", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotLike(String value) {
            addCriterion("communication_type not like", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIn(List<String> values) {
            addCriterion("communication_type in", values, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotIn(List<String> values) {
            addCriterion("communication_type not in", values, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeBetween(String value1, String value2) {
            addCriterion("communication_type between", value1, value2, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotBetween(String value1, String value2) {
            addCriterion("communication_type not between", value1, value2, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementIsNull() {
            addCriterion("communication_agreement is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementIsNotNull() {
            addCriterion("communication_agreement is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementEqualTo(String value) {
            addCriterion("communication_agreement =", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementNotEqualTo(String value) {
            addCriterion("communication_agreement <>", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementGreaterThan(String value) {
            addCriterion("communication_agreement >", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("communication_agreement >=", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementLessThan(String value) {
            addCriterion("communication_agreement <", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementLessThanOrEqualTo(String value) {
            addCriterion("communication_agreement <=", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementLike(String value) {
            addCriterion("communication_agreement like", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementNotLike(String value) {
            addCriterion("communication_agreement not like", value, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementIn(List<String> values) {
            addCriterion("communication_agreement in", values, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementNotIn(List<String> values) {
            addCriterion("communication_agreement not in", values, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementBetween(String value1, String value2) {
            addCriterion("communication_agreement between", value1, value2, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationAgreementNotBetween(String value1, String value2) {
            addCriterion("communication_agreement not between", value1, value2, "communicationAgreement");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalIsNull() {
            addCriterion("communication_protocal is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalIsNotNull() {
            addCriterion("communication_protocal is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalEqualTo(String value) {
            addCriterion("communication_protocal =", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalNotEqualTo(String value) {
            addCriterion("communication_protocal <>", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalGreaterThan(String value) {
            addCriterion("communication_protocal >", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalGreaterThanOrEqualTo(String value) {
            addCriterion("communication_protocal >=", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalLessThan(String value) {
            addCriterion("communication_protocal <", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalLessThanOrEqualTo(String value) {
            addCriterion("communication_protocal <=", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalLike(String value) {
            addCriterion("communication_protocal like", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalNotLike(String value) {
            addCriterion("communication_protocal not like", value, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalIn(List<String> values) {
            addCriterion("communication_protocal in", values, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalNotIn(List<String> values) {
            addCriterion("communication_protocal not in", values, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalBetween(String value1, String value2) {
            addCriterion("communication_protocal between", value1, value2, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andCommunicationProtocalNotBetween(String value1, String value2) {
            addCriterion("communication_protocal not between", value1, value2, "communicationProtocal");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressIsNull() {
            addCriterion("term_commte_address is null");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressIsNotNull() {
            addCriterion("term_commte_address is not null");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressEqualTo(String value) {
            addCriterion("term_commte_address =", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressNotEqualTo(String value) {
            addCriterion("term_commte_address <>", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressGreaterThan(String value) {
            addCriterion("term_commte_address >", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressGreaterThanOrEqualTo(String value) {
            addCriterion("term_commte_address >=", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressLessThan(String value) {
            addCriterion("term_commte_address <", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressLessThanOrEqualTo(String value) {
            addCriterion("term_commte_address <=", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressLike(String value) {
            addCriterion("term_commte_address like", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressNotLike(String value) {
            addCriterion("term_commte_address not like", value, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressIn(List<String> values) {
            addCriterion("term_commte_address in", values, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressNotIn(List<String> values) {
            addCriterion("term_commte_address not in", values, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressBetween(String value1, String value2) {
            addCriterion("term_commte_address between", value1, value2, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andTermCommteAddressNotBetween(String value1, String value2) {
            addCriterion("term_commte_address not between", value1, value2, "termCommteAddress");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpIsNull() {
            addCriterion("master_address_ip is null");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpIsNotNull() {
            addCriterion("master_address_ip is not null");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpEqualTo(String value) {
            addCriterion("master_address_ip =", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpNotEqualTo(String value) {
            addCriterion("master_address_ip <>", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpGreaterThan(String value) {
            addCriterion("master_address_ip >", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpGreaterThanOrEqualTo(String value) {
            addCriterion("master_address_ip >=", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpLessThan(String value) {
            addCriterion("master_address_ip <", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpLessThanOrEqualTo(String value) {
            addCriterion("master_address_ip <=", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpLike(String value) {
            addCriterion("master_address_ip like", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpNotLike(String value) {
            addCriterion("master_address_ip not like", value, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpIn(List<String> values) {
            addCriterion("master_address_ip in", values, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpNotIn(List<String> values) {
            addCriterion("master_address_ip not in", values, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpBetween(String value1, String value2) {
            addCriterion("master_address_ip between", value1, value2, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterAddressIpNotBetween(String value1, String value2) {
            addCriterion("master_address_ip not between", value1, value2, "masterAddressIp");
            return (Criteria) this;
        }

        public Criteria andMasterPortIsNull() {
            addCriterion("master_port is null");
            return (Criteria) this;
        }

        public Criteria andMasterPortIsNotNull() {
            addCriterion("master_port is not null");
            return (Criteria) this;
        }

        public Criteria andMasterPortEqualTo(String value) {
            addCriterion("master_port =", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortNotEqualTo(String value) {
            addCriterion("master_port <>", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortGreaterThan(String value) {
            addCriterion("master_port >", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortGreaterThanOrEqualTo(String value) {
            addCriterion("master_port >=", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortLessThan(String value) {
            addCriterion("master_port <", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortLessThanOrEqualTo(String value) {
            addCriterion("master_port <=", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortLike(String value) {
            addCriterion("master_port like", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortNotLike(String value) {
            addCriterion("master_port not like", value, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortIn(List<String> values) {
            addCriterion("master_port in", values, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortNotIn(List<String> values) {
            addCriterion("master_port not in", values, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortBetween(String value1, String value2) {
            addCriterion("master_port between", value1, value2, "masterPort");
            return (Criteria) this;
        }

        public Criteria andMasterPortNotBetween(String value1, String value2) {
            addCriterion("master_port not between", value1, value2, "masterPort");
            return (Criteria) this;
        }

        public Criteria andIsNewNormIsNull() {
            addCriterion("is_new_norm is null");
            return (Criteria) this;
        }

        public Criteria andIsNewNormIsNotNull() {
            addCriterion("is_new_norm is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewNormEqualTo(String value) {
            addCriterion("is_new_norm =", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormNotEqualTo(String value) {
            addCriterion("is_new_norm <>", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormGreaterThan(String value) {
            addCriterion("is_new_norm >", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormGreaterThanOrEqualTo(String value) {
            addCriterion("is_new_norm >=", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormLessThan(String value) {
            addCriterion("is_new_norm <", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormLessThanOrEqualTo(String value) {
            addCriterion("is_new_norm <=", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormLike(String value) {
            addCriterion("is_new_norm like", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormNotLike(String value) {
            addCriterion("is_new_norm not like", value, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormIn(List<String> values) {
            addCriterion("is_new_norm in", values, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormNotIn(List<String> values) {
            addCriterion("is_new_norm not in", values, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormBetween(String value1, String value2) {
            addCriterion("is_new_norm between", value1, value2, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andIsNewNormNotBetween(String value1, String value2) {
            addCriterion("is_new_norm not between", value1, value2, "isNewNorm");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNull() {
            addCriterion("import_time is null");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNotNull() {
            addCriterion("import_time is not null");
            return (Criteria) this;
        }

        public Criteria andImportTimeEqualTo(Date value) {
            addCriterion("import_time =", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotEqualTo(Date value) {
            addCriterion("import_time <>", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThan(Date value) {
            addCriterion("import_time >", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_time >=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThan(Date value) {
            addCriterion("import_time <", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThanOrEqualTo(Date value) {
            addCriterion("import_time <=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeIn(List<Date> values) {
            addCriterion("import_time in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotIn(List<Date> values) {
            addCriterion("import_time not in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeBetween(Date value1, Date value2) {
            addCriterion("import_time between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotBetween(Date value1, Date value2) {
            addCriterion("import_time not between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNull() {
            addCriterion("device_address is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNotNull() {
            addCriterion("device_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressEqualTo(String value) {
            addCriterion("device_address =", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotEqualTo(String value) {
            addCriterion("device_address <>", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThan(String value) {
            addCriterion("device_address >", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("device_address >=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThan(String value) {
            addCriterion("device_address <", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThanOrEqualTo(String value) {
            addCriterion("device_address <=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLike(String value) {
            addCriterion("device_address like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotLike(String value) {
            addCriterion("device_address not like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIn(List<String> values) {
            addCriterion("device_address in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotIn(List<String> values) {
            addCriterion("device_address not in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressBetween(String value1, String value2) {
            addCriterion("device_address between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotBetween(String value1, String value2) {
            addCriterion("device_address not between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeIsNull() {
            addCriterion("gd_longitude is null");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeIsNotNull() {
            addCriterion("gd_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeEqualTo(String value) {
            addCriterion("gd_longitude =", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeNotEqualTo(String value) {
            addCriterion("gd_longitude <>", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeGreaterThan(String value) {
            addCriterion("gd_longitude >", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("gd_longitude >=", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeLessThan(String value) {
            addCriterion("gd_longitude <", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeLessThanOrEqualTo(String value) {
            addCriterion("gd_longitude <=", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeLike(String value) {
            addCriterion("gd_longitude like", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeNotLike(String value) {
            addCriterion("gd_longitude not like", value, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeIn(List<String> values) {
            addCriterion("gd_longitude in", values, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeNotIn(List<String> values) {
            addCriterion("gd_longitude not in", values, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeBetween(String value1, String value2) {
            addCriterion("gd_longitude between", value1, value2, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLongitudeNotBetween(String value1, String value2) {
            addCriterion("gd_longitude not between", value1, value2, "gdLongitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeIsNull() {
            addCriterion("gd_latitude is null");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeIsNotNull() {
            addCriterion("gd_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeEqualTo(String value) {
            addCriterion("gd_latitude =", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeNotEqualTo(String value) {
            addCriterion("gd_latitude <>", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeGreaterThan(String value) {
            addCriterion("gd_latitude >", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("gd_latitude >=", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeLessThan(String value) {
            addCriterion("gd_latitude <", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeLessThanOrEqualTo(String value) {
            addCriterion("gd_latitude <=", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeLike(String value) {
            addCriterion("gd_latitude like", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeNotLike(String value) {
            addCriterion("gd_latitude not like", value, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeIn(List<String> values) {
            addCriterion("gd_latitude in", values, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeNotIn(List<String> values) {
            addCriterion("gd_latitude not in", values, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeBetween(String value1, String value2) {
            addCriterion("gd_latitude between", value1, value2, "gdLatitude");
            return (Criteria) this;
        }

        public Criteria andGdLatitudeNotBetween(String value1, String value2) {
            addCriterion("gd_latitude not between", value1, value2, "gdLatitude");
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

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNull() {
            addCriterion("is_register is null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNotNull() {
            addCriterion("is_register is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterEqualTo(String value) {
            addCriterion("is_register =", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotEqualTo(String value) {
            addCriterion("is_register <>", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThan(String value) {
            addCriterion("is_register >", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("is_register >=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThan(String value) {
            addCriterion("is_register <", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThanOrEqualTo(String value) {
            addCriterion("is_register <=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLike(String value) {
            addCriterion("is_register like", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotLike(String value) {
            addCriterion("is_register not like", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIn(List<String> values) {
            addCriterion("is_register in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotIn(List<String> values) {
            addCriterion("is_register not in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterBetween(String value1, String value2) {
            addCriterion("is_register between", value1, value2, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotBetween(String value1, String value2) {
            addCriterion("is_register not between", value1, value2, "isRegister");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIsNull() {
            addCriterion("register_user is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIsNotNull() {
            addCriterion("register_user is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserEqualTo(String value) {
            addCriterion("register_user =", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotEqualTo(String value) {
            addCriterion("register_user <>", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserGreaterThan(String value) {
            addCriterion("register_user >", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserGreaterThanOrEqualTo(String value) {
            addCriterion("register_user >=", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLessThan(String value) {
            addCriterion("register_user <", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLessThanOrEqualTo(String value) {
            addCriterion("register_user <=", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserLike(String value) {
            addCriterion("register_user like", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotLike(String value) {
            addCriterion("register_user not like", value, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIn(List<String> values) {
            addCriterion("register_user in", values, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotIn(List<String> values) {
            addCriterion("register_user not in", values, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserBetween(String value1, String value2) {
            addCriterion("register_user between", value1, value2, "registerUser");
            return (Criteria) this;
        }

        public Criteria andRegisterUserNotBetween(String value1, String value2) {
            addCriterion("register_user not between", value1, value2, "registerUser");
            return (Criteria) this;
        }

        public Criteria andIsCancelIsNull() {
            addCriterion("is_cancel is null");
            return (Criteria) this;
        }

        public Criteria andIsCancelIsNotNull() {
            addCriterion("is_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andIsCancelEqualTo(String value) {
            addCriterion("is_cancel =", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotEqualTo(String value) {
            addCriterion("is_cancel <>", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThan(String value) {
            addCriterion("is_cancel >", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThanOrEqualTo(String value) {
            addCriterion("is_cancel >=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThan(String value) {
            addCriterion("is_cancel <", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThanOrEqualTo(String value) {
            addCriterion("is_cancel <=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLike(String value) {
            addCriterion("is_cancel like", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotLike(String value) {
            addCriterion("is_cancel not like", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelIn(List<String> values) {
            addCriterion("is_cancel in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotIn(List<String> values) {
            addCriterion("is_cancel not in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelBetween(String value1, String value2) {
            addCriterion("is_cancel between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotBetween(String value1, String value2) {
            addCriterion("is_cancel not between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelUserIsNull() {
            addCriterion("cancel_user is null");
            return (Criteria) this;
        }

        public Criteria andCancelUserIsNotNull() {
            addCriterion("cancel_user is not null");
            return (Criteria) this;
        }

        public Criteria andCancelUserEqualTo(String value) {
            addCriterion("cancel_user =", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserNotEqualTo(String value) {
            addCriterion("cancel_user <>", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserGreaterThan(String value) {
            addCriterion("cancel_user >", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_user >=", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserLessThan(String value) {
            addCriterion("cancel_user <", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserLessThanOrEqualTo(String value) {
            addCriterion("cancel_user <=", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserLike(String value) {
            addCriterion("cancel_user like", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserNotLike(String value) {
            addCriterion("cancel_user not like", value, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserIn(List<String> values) {
            addCriterion("cancel_user in", values, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserNotIn(List<String> values) {
            addCriterion("cancel_user not in", values, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserBetween(String value1, String value2) {
            addCriterion("cancel_user between", value1, value2, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andCancelUserNotBetween(String value1, String value2) {
            addCriterion("cancel_user not between", value1, value2, "cancelUser");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatIsNull() {
            addCriterion("is_identificat is null");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatIsNotNull() {
            addCriterion("is_identificat is not null");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatEqualTo(String value) {
            addCriterion("is_identificat =", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatNotEqualTo(String value) {
            addCriterion("is_identificat <>", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatGreaterThan(String value) {
            addCriterion("is_identificat >", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatGreaterThanOrEqualTo(String value) {
            addCriterion("is_identificat >=", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatLessThan(String value) {
            addCriterion("is_identificat <", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatLessThanOrEqualTo(String value) {
            addCriterion("is_identificat <=", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatLike(String value) {
            addCriterion("is_identificat like", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatNotLike(String value) {
            addCriterion("is_identificat not like", value, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatIn(List<String> values) {
            addCriterion("is_identificat in", values, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatNotIn(List<String> values) {
            addCriterion("is_identificat not in", values, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatBetween(String value1, String value2) {
            addCriterion("is_identificat between", value1, value2, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIsIdentificatNotBetween(String value1, String value2) {
            addCriterion("is_identificat not between", value1, value2, "isIdentificat");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeIsNull() {
            addCriterion("identificat_time is null");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeIsNotNull() {
            addCriterion("identificat_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeEqualTo(Date value) {
            addCriterion("identificat_time =", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeNotEqualTo(Date value) {
            addCriterion("identificat_time <>", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeGreaterThan(Date value) {
            addCriterion("identificat_time >", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("identificat_time >=", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeLessThan(Date value) {
            addCriterion("identificat_time <", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeLessThanOrEqualTo(Date value) {
            addCriterion("identificat_time <=", value, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeIn(List<Date> values) {
            addCriterion("identificat_time in", values, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeNotIn(List<Date> values) {
            addCriterion("identificat_time not in", values, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeBetween(Date value1, Date value2) {
            addCriterion("identificat_time between", value1, value2, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificatTimeNotBetween(Date value1, Date value2) {
            addCriterion("identificat_time not between", value1, value2, "identificatTime");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserIsNull() {
            addCriterion("identifica_user is null");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserIsNotNull() {
            addCriterion("identifica_user is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserEqualTo(String value) {
            addCriterion("identifica_user =", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserNotEqualTo(String value) {
            addCriterion("identifica_user <>", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserGreaterThan(String value) {
            addCriterion("identifica_user >", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserGreaterThanOrEqualTo(String value) {
            addCriterion("identifica_user >=", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserLessThan(String value) {
            addCriterion("identifica_user <", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserLessThanOrEqualTo(String value) {
            addCriterion("identifica_user <=", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserLike(String value) {
            addCriterion("identifica_user like", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserNotLike(String value) {
            addCriterion("identifica_user not like", value, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserIn(List<String> values) {
            addCriterion("identifica_user in", values, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserNotIn(List<String> values) {
            addCriterion("identifica_user not in", values, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserBetween(String value1, String value2) {
            addCriterion("identifica_user between", value1, value2, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andIdentificaUserNotBetween(String value1, String value2) {
            addCriterion("identifica_user not between", value1, value2, "identificaUser");
            return (Criteria) this;
        }

        public Criteria andRightUniteIsNull() {
            addCriterion("right_unite is null");
            return (Criteria) this;
        }

        public Criteria andRightUniteIsNotNull() {
            addCriterion("right_unite is not null");
            return (Criteria) this;
        }

        public Criteria andRightUniteEqualTo(String value) {
            addCriterion("right_unite =", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteNotEqualTo(String value) {
            addCriterion("right_unite <>", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteGreaterThan(String value) {
            addCriterion("right_unite >", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteGreaterThanOrEqualTo(String value) {
            addCriterion("right_unite >=", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteLessThan(String value) {
            addCriterion("right_unite <", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteLessThanOrEqualTo(String value) {
            addCriterion("right_unite <=", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteLike(String value) {
            addCriterion("right_unite like", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteNotLike(String value) {
            addCriterion("right_unite not like", value, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteIn(List<String> values) {
            addCriterion("right_unite in", values, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteNotIn(List<String> values) {
            addCriterion("right_unite not in", values, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteBetween(String value1, String value2) {
            addCriterion("right_unite between", value1, value2, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andRightUniteNotBetween(String value1, String value2) {
            addCriterion("right_unite not between", value1, value2, "rightUnite");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumIsNull() {
            addCriterion("business_system_devicenum is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumIsNotNull() {
            addCriterion("business_system_devicenum is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumEqualTo(String value) {
            addCriterion("business_system_devicenum =", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumNotEqualTo(String value) {
            addCriterion("business_system_devicenum <>", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumGreaterThan(String value) {
            addCriterion("business_system_devicenum >", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumGreaterThanOrEqualTo(String value) {
            addCriterion("business_system_devicenum >=", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumLessThan(String value) {
            addCriterion("business_system_devicenum <", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumLessThanOrEqualTo(String value) {
            addCriterion("business_system_devicenum <=", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumLike(String value) {
            addCriterion("business_system_devicenum like", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumNotLike(String value) {
            addCriterion("business_system_devicenum not like", value, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumIn(List<String> values) {
            addCriterion("business_system_devicenum in", values, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumNotIn(List<String> values) {
            addCriterion("business_system_devicenum not in", values, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumBetween(String value1, String value2) {
            addCriterion("business_system_devicenum between", value1, value2, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemDevicenumNotBetween(String value1, String value2) {
            addCriterion("business_system_devicenum not between", value1, value2, "businessSystemDevicenum");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameIsNull() {
            addCriterion("opsystem_name is null");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameIsNotNull() {
            addCriterion("opsystem_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameEqualTo(String value) {
            addCriterion("opsystem_name =", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameNotEqualTo(String value) {
            addCriterion("opsystem_name <>", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameGreaterThan(String value) {
            addCriterion("opsystem_name >", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("opsystem_name >=", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameLessThan(String value) {
            addCriterion("opsystem_name <", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameLessThanOrEqualTo(String value) {
            addCriterion("opsystem_name <=", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameLike(String value) {
            addCriterion("opsystem_name like", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameNotLike(String value) {
            addCriterion("opsystem_name not like", value, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameIn(List<String> values) {
            addCriterion("opsystem_name in", values, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameNotIn(List<String> values) {
            addCriterion("opsystem_name not in", values, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameBetween(String value1, String value2) {
            addCriterion("opsystem_name between", value1, value2, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemNameNotBetween(String value1, String value2) {
            addCriterion("opsystem_name not between", value1, value2, "opsystemName");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeIsNull() {
            addCriterion("opsystem_type is null");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeIsNotNull() {
            addCriterion("opsystem_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeEqualTo(String value) {
            addCriterion("opsystem_type =", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeNotEqualTo(String value) {
            addCriterion("opsystem_type <>", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeGreaterThan(String value) {
            addCriterion("opsystem_type >", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("opsystem_type >=", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeLessThan(String value) {
            addCriterion("opsystem_type <", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeLessThanOrEqualTo(String value) {
            addCriterion("opsystem_type <=", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeLike(String value) {
            addCriterion("opsystem_type like", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeNotLike(String value) {
            addCriterion("opsystem_type not like", value, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeIn(List<String> values) {
            addCriterion("opsystem_type in", values, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeNotIn(List<String> values) {
            addCriterion("opsystem_type not in", values, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeBetween(String value1, String value2) {
            addCriterion("opsystem_type between", value1, value2, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemTypeNotBetween(String value1, String value2) {
            addCriterion("opsystem_type not between", value1, value2, "opsystemType");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionIsNull() {
            addCriterion("opsystem_version is null");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionIsNotNull() {
            addCriterion("opsystem_version is not null");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionEqualTo(String value) {
            addCriterion("opsystem_version =", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionNotEqualTo(String value) {
            addCriterion("opsystem_version <>", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionGreaterThan(String value) {
            addCriterion("opsystem_version >", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionGreaterThanOrEqualTo(String value) {
            addCriterion("opsystem_version >=", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionLessThan(String value) {
            addCriterion("opsystem_version <", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionLessThanOrEqualTo(String value) {
            addCriterion("opsystem_version <=", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionLike(String value) {
            addCriterion("opsystem_version like", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionNotLike(String value) {
            addCriterion("opsystem_version not like", value, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionIn(List<String> values) {
            addCriterion("opsystem_version in", values, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionNotIn(List<String> values) {
            addCriterion("opsystem_version not in", values, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionBetween(String value1, String value2) {
            addCriterion("opsystem_version between", value1, value2, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemVersionNotBetween(String value1, String value2) {
            addCriterion("opsystem_version not between", value1, value2, "opsystemVersion");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdIsNull() {
            addCriterion("opsystem_id is null");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdIsNotNull() {
            addCriterion("opsystem_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdEqualTo(String value) {
            addCriterion("opsystem_id =", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdNotEqualTo(String value) {
            addCriterion("opsystem_id <>", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdGreaterThan(String value) {
            addCriterion("opsystem_id >", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("opsystem_id >=", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdLessThan(String value) {
            addCriterion("opsystem_id <", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdLessThanOrEqualTo(String value) {
            addCriterion("opsystem_id <=", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdLike(String value) {
            addCriterion("opsystem_id like", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdNotLike(String value) {
            addCriterion("opsystem_id not like", value, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdIn(List<String> values) {
            addCriterion("opsystem_id in", values, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdNotIn(List<String> values) {
            addCriterion("opsystem_id not in", values, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdBetween(String value1, String value2) {
            addCriterion("opsystem_id between", value1, value2, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andOpsystemIdNotBetween(String value1, String value2) {
            addCriterion("opsystem_id not between", value1, value2, "opsystemId");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteIsNull() {
            addCriterion("system_develop_unite is null");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteIsNotNull() {
            addCriterion("system_develop_unite is not null");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteEqualTo(String value) {
            addCriterion("system_develop_unite =", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteNotEqualTo(String value) {
            addCriterion("system_develop_unite <>", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteGreaterThan(String value) {
            addCriterion("system_develop_unite >", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteGreaterThanOrEqualTo(String value) {
            addCriterion("system_develop_unite >=", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteLessThan(String value) {
            addCriterion("system_develop_unite <", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteLessThanOrEqualTo(String value) {
            addCriterion("system_develop_unite <=", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteLike(String value) {
            addCriterion("system_develop_unite like", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteNotLike(String value) {
            addCriterion("system_develop_unite not like", value, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteIn(List<String> values) {
            addCriterion("system_develop_unite in", values, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteNotIn(List<String> values) {
            addCriterion("system_develop_unite not in", values, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteBetween(String value1, String value2) {
            addCriterion("system_develop_unite between", value1, value2, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andSystemDevelopUniteNotBetween(String value1, String value2) {
            addCriterion("system_develop_unite not between", value1, value2, "systemDevelopUnite");
            return (Criteria) this;
        }

        public Criteria andOptionUserIsNull() {
            addCriterion("option_user is null");
            return (Criteria) this;
        }

        public Criteria andOptionUserIsNotNull() {
            addCriterion("option_user is not null");
            return (Criteria) this;
        }

        public Criteria andOptionUserEqualTo(String value) {
            addCriterion("option_user =", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserNotEqualTo(String value) {
            addCriterion("option_user <>", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserGreaterThan(String value) {
            addCriterion("option_user >", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserGreaterThanOrEqualTo(String value) {
            addCriterion("option_user >=", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserLessThan(String value) {
            addCriterion("option_user <", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserLessThanOrEqualTo(String value) {
            addCriterion("option_user <=", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserLike(String value) {
            addCriterion("option_user like", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserNotLike(String value) {
            addCriterion("option_user not like", value, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserIn(List<String> values) {
            addCriterion("option_user in", values, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserNotIn(List<String> values) {
            addCriterion("option_user not in", values, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserBetween(String value1, String value2) {
            addCriterion("option_user between", value1, value2, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionUserNotBetween(String value1, String value2) {
            addCriterion("option_user not between", value1, value2, "optionUser");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIsNull() {
            addCriterion("option_time is null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIsNotNull() {
            addCriterion("option_time is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeEqualTo(Date value) {
            addCriterion("option_time =", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotEqualTo(Date value) {
            addCriterion("option_time <>", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeGreaterThan(Date value) {
            addCriterion("option_time >", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("option_time >=", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeLessThan(Date value) {
            addCriterion("option_time <", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeLessThanOrEqualTo(Date value) {
            addCriterion("option_time <=", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIn(List<Date> values) {
            addCriterion("option_time in", values, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotIn(List<Date> values) {
            addCriterion("option_time not in", values, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeBetween(Date value1, Date value2) {
            addCriterion("option_time between", value1, value2, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotBetween(Date value1, Date value2) {
            addCriterion("option_time not between", value1, value2, "optionTime");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(String value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(String value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(String value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(String value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(String value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLike(String value) {
            addCriterion("device_status like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotLike(String value) {
            addCriterion("device_status not like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<String> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<String> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(String value1, String value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(String value1, String value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andCpusIsNull() {
            addCriterion("cpus is null");
            return (Criteria) this;
        }

        public Criteria andCpusIsNotNull() {
            addCriterion("cpus is not null");
            return (Criteria) this;
        }

        public Criteria andCpusEqualTo(Integer value) {
            addCriterion("cpus =", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusNotEqualTo(Integer value) {
            addCriterion("cpus <>", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusGreaterThan(Integer value) {
            addCriterion("cpus >", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpus >=", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusLessThan(Integer value) {
            addCriterion("cpus <", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusLessThanOrEqualTo(Integer value) {
            addCriterion("cpus <=", value, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusIn(List<Integer> values) {
            addCriterion("cpus in", values, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusNotIn(List<Integer> values) {
            addCriterion("cpus not in", values, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusBetween(Integer value1, Integer value2) {
            addCriterion("cpus between", value1, value2, "cpus");
            return (Criteria) this;
        }

        public Criteria andCpusNotBetween(Integer value1, Integer value2) {
            addCriterion("cpus not between", value1, value2, "cpus");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andCacheIsNull() {
            addCriterion("cache is null");
            return (Criteria) this;
        }

        public Criteria andCacheIsNotNull() {
            addCriterion("cache is not null");
            return (Criteria) this;
        }

        public Criteria andCacheEqualTo(Integer value) {
            addCriterion("cache =", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotEqualTo(Integer value) {
            addCriterion("cache <>", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThan(Integer value) {
            addCriterion("cache >", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThanOrEqualTo(Integer value) {
            addCriterion("cache >=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThan(Integer value) {
            addCriterion("cache <", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThanOrEqualTo(Integer value) {
            addCriterion("cache <=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheIn(List<Integer> values) {
            addCriterion("cache in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotIn(List<Integer> values) {
            addCriterion("cache not in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheBetween(Integer value1, Integer value2) {
            addCriterion("cache between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotBetween(Integer value1, Integer value2) {
            addCriterion("cache not between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andArchIsNull() {
            addCriterion("arch is null");
            return (Criteria) this;
        }

        public Criteria andArchIsNotNull() {
            addCriterion("arch is not null");
            return (Criteria) this;
        }

        public Criteria andArchEqualTo(String value) {
            addCriterion("arch =", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchNotEqualTo(String value) {
            addCriterion("arch <>", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchGreaterThan(String value) {
            addCriterion("arch >", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchGreaterThanOrEqualTo(String value) {
            addCriterion("arch >=", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchLessThan(String value) {
            addCriterion("arch <", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchLessThanOrEqualTo(String value) {
            addCriterion("arch <=", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchLike(String value) {
            addCriterion("arch like", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchNotLike(String value) {
            addCriterion("arch not like", value, "arch");
            return (Criteria) this;
        }

        public Criteria andArchIn(List<String> values) {
            addCriterion("arch in", values, "arch");
            return (Criteria) this;
        }

        public Criteria andArchNotIn(List<String> values) {
            addCriterion("arch not in", values, "arch");
            return (Criteria) this;
        }

        public Criteria andArchBetween(String value1, String value2) {
            addCriterion("arch between", value1, value2, "arch");
            return (Criteria) this;
        }

        public Criteria andArchNotBetween(String value1, String value2) {
            addCriterion("arch not between", value1, value2, "arch");
            return (Criteria) this;
        }

        public Criteria andCpuLmtIsNull() {
            addCriterion("cpu_lmt is null");
            return (Criteria) this;
        }

        public Criteria andCpuLmtIsNotNull() {
            addCriterion("cpu_lmt is not null");
            return (Criteria) this;
        }

        public Criteria andCpuLmtEqualTo(Integer value) {
            addCriterion("cpu_lmt =", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtNotEqualTo(Integer value) {
            addCriterion("cpu_lmt <>", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtGreaterThan(Integer value) {
            addCriterion("cpu_lmt >", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpu_lmt >=", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtLessThan(Integer value) {
            addCriterion("cpu_lmt <", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtLessThanOrEqualTo(Integer value) {
            addCriterion("cpu_lmt <=", value, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtIn(List<Integer> values) {
            addCriterion("cpu_lmt in", values, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtNotIn(List<Integer> values) {
            addCriterion("cpu_lmt not in", values, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtBetween(Integer value1, Integer value2) {
            addCriterion("cpu_lmt between", value1, value2, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andCpuLmtNotBetween(Integer value1, Integer value2) {
            addCriterion("cpu_lmt not between", value1, value2, "cpuLmt");
            return (Criteria) this;
        }

        public Criteria andPhyIsNull() {
            addCriterion("phy is null");
            return (Criteria) this;
        }

        public Criteria andPhyIsNotNull() {
            addCriterion("phy is not null");
            return (Criteria) this;
        }

        public Criteria andPhyEqualTo(Integer value) {
            addCriterion("phy =", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyNotEqualTo(Integer value) {
            addCriterion("phy <>", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyGreaterThan(Integer value) {
            addCriterion("phy >", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyGreaterThanOrEqualTo(Integer value) {
            addCriterion("phy >=", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyLessThan(Integer value) {
            addCriterion("phy <", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyLessThanOrEqualTo(Integer value) {
            addCriterion("phy <=", value, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyIn(List<Integer> values) {
            addCriterion("phy in", values, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyNotIn(List<Integer> values) {
            addCriterion("phy not in", values, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyBetween(Integer value1, Integer value2) {
            addCriterion("phy between", value1, value2, "phy");
            return (Criteria) this;
        }

        public Criteria andPhyNotBetween(Integer value1, Integer value2) {
            addCriterion("phy not between", value1, value2, "phy");
            return (Criteria) this;
        }

        public Criteria andVirtIsNull() {
            addCriterion("virt is null");
            return (Criteria) this;
        }

        public Criteria andVirtIsNotNull() {
            addCriterion("virt is not null");
            return (Criteria) this;
        }

        public Criteria andVirtEqualTo(Integer value) {
            addCriterion("virt =", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtNotEqualTo(Integer value) {
            addCriterion("virt <>", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtGreaterThan(Integer value) {
            addCriterion("virt >", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtGreaterThanOrEqualTo(Integer value) {
            addCriterion("virt >=", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtLessThan(Integer value) {
            addCriterion("virt <", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtLessThanOrEqualTo(Integer value) {
            addCriterion("virt <=", value, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtIn(List<Integer> values) {
            addCriterion("virt in", values, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtNotIn(List<Integer> values) {
            addCriterion("virt not in", values, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtBetween(Integer value1, Integer value2) {
            addCriterion("virt between", value1, value2, "virt");
            return (Criteria) this;
        }

        public Criteria andVirtNotBetween(Integer value1, Integer value2) {
            addCriterion("virt not between", value1, value2, "virt");
            return (Criteria) this;
        }

        public Criteria andMemLmtIsNull() {
            addCriterion("mem_lmt is null");
            return (Criteria) this;
        }

        public Criteria andMemLmtIsNotNull() {
            addCriterion("mem_lmt is not null");
            return (Criteria) this;
        }

        public Criteria andMemLmtEqualTo(Integer value) {
            addCriterion("mem_lmt =", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtNotEqualTo(Integer value) {
            addCriterion("mem_lmt <>", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtGreaterThan(Integer value) {
            addCriterion("mem_lmt >", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("mem_lmt >=", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtLessThan(Integer value) {
            addCriterion("mem_lmt <", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtLessThanOrEqualTo(Integer value) {
            addCriterion("mem_lmt <=", value, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtIn(List<Integer> values) {
            addCriterion("mem_lmt in", values, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtNotIn(List<Integer> values) {
            addCriterion("mem_lmt not in", values, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtBetween(Integer value1, Integer value2) {
            addCriterion("mem_lmt between", value1, value2, "memLmt");
            return (Criteria) this;
        }

        public Criteria andMemLmtNotBetween(Integer value1, Integer value2) {
            addCriterion("mem_lmt not between", value1, value2, "memLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Integer value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Integer value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Integer value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Integer value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Integer> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Integer> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Integer value1, Integer value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtIsNull() {
            addCriterion("volume_lmt is null");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtIsNotNull() {
            addCriterion("volume_lmt is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtEqualTo(Integer value) {
            addCriterion("volume_lmt =", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtNotEqualTo(Integer value) {
            addCriterion("volume_lmt <>", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtGreaterThan(Integer value) {
            addCriterion("volume_lmt >", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume_lmt >=", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtLessThan(Integer value) {
            addCriterion("volume_lmt <", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtLessThanOrEqualTo(Integer value) {
            addCriterion("volume_lmt <=", value, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtIn(List<Integer> values) {
            addCriterion("volume_lmt in", values, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtNotIn(List<Integer> values) {
            addCriterion("volume_lmt not in", values, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtBetween(Integer value1, Integer value2) {
            addCriterion("volume_lmt between", value1, value2, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andVolumeLmtNotBetween(Integer value1, Integer value2) {
            addCriterion("volume_lmt not between", value1, value2, "volumeLmt");
            return (Criteria) this;
        }

        public Criteria andDistroIsNull() {
            addCriterion("distro is null");
            return (Criteria) this;
        }

        public Criteria andDistroIsNotNull() {
            addCriterion("distro is not null");
            return (Criteria) this;
        }

        public Criteria andDistroEqualTo(String value) {
            addCriterion("distro =", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroNotEqualTo(String value) {
            addCriterion("distro <>", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroGreaterThan(String value) {
            addCriterion("distro >", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroGreaterThanOrEqualTo(String value) {
            addCriterion("distro >=", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroLessThan(String value) {
            addCriterion("distro <", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroLessThanOrEqualTo(String value) {
            addCriterion("distro <=", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroLike(String value) {
            addCriterion("distro like", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroNotLike(String value) {
            addCriterion("distro not like", value, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroIn(List<String> values) {
            addCriterion("distro in", values, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroNotIn(List<String> values) {
            addCriterion("distro not in", values, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroBetween(String value1, String value2) {
            addCriterion("distro between", value1, value2, "distro");
            return (Criteria) this;
        }

        public Criteria andDistroNotBetween(String value1, String value2) {
            addCriterion("distro not between", value1, value2, "distro");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andKernelIsNull() {
            addCriterion("kernel is null");
            return (Criteria) this;
        }

        public Criteria andKernelIsNotNull() {
            addCriterion("kernel is not null");
            return (Criteria) this;
        }

        public Criteria andKernelEqualTo(String value) {
            addCriterion("kernel =", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelNotEqualTo(String value) {
            addCriterion("kernel <>", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelGreaterThan(String value) {
            addCriterion("kernel >", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelGreaterThanOrEqualTo(String value) {
            addCriterion("kernel >=", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelLessThan(String value) {
            addCriterion("kernel <", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelLessThanOrEqualTo(String value) {
            addCriterion("kernel <=", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelLike(String value) {
            addCriterion("kernel like", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelNotLike(String value) {
            addCriterion("kernel not like", value, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelIn(List<String> values) {
            addCriterion("kernel in", values, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelNotIn(List<String> values) {
            addCriterion("kernel not in", values, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelBetween(String value1, String value2) {
            addCriterion("kernel between", value1, value2, "kernel");
            return (Criteria) this;
        }

        public Criteria andKernelNotBetween(String value1, String value2) {
            addCriterion("kernel not between", value1, value2, "kernel");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNull() {
            addCriterion("soft_version is null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNotNull() {
            addCriterion("soft_version is not null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionEqualTo(String value) {
            addCriterion("soft_version =", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotEqualTo(String value) {
            addCriterion("soft_version <>", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThan(String value) {
            addCriterion("soft_version >", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThanOrEqualTo(String value) {
            addCriterion("soft_version >=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThan(String value) {
            addCriterion("soft_version <", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThanOrEqualTo(String value) {
            addCriterion("soft_version <=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLike(String value) {
            addCriterion("soft_version like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotLike(String value) {
            addCriterion("soft_version not like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIn(List<String> values) {
            addCriterion("soft_version in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotIn(List<String> values) {
            addCriterion("soft_version not in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionBetween(String value1, String value2) {
            addCriterion("soft_version between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotBetween(String value1, String value2) {
            addCriterion("soft_version not between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andTempIsNull() {
            addCriterion("temp is null");
            return (Criteria) this;
        }

        public Criteria andTempIsNotNull() {
            addCriterion("temp is not null");
            return (Criteria) this;
        }

        public Criteria andTempEqualTo(Integer value) {
            addCriterion("temp =", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotEqualTo(Integer value) {
            addCriterion("temp <>", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThan(Integer value) {
            addCriterion("temp >", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp >=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThan(Integer value) {
            addCriterion("temp <", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThanOrEqualTo(Integer value) {
            addCriterion("temp <=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempIn(List<Integer> values) {
            addCriterion("temp in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotIn(List<Integer> values) {
            addCriterion("temp not in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempBetween(Integer value1, Integer value2) {
            addCriterion("temp between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotBetween(Integer value1, Integer value2) {
            addCriterion("temp not between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTemLowIsNull() {
            addCriterion("tem_low is null");
            return (Criteria) this;
        }

        public Criteria andTemLowIsNotNull() {
            addCriterion("tem_low is not null");
            return (Criteria) this;
        }

        public Criteria andTemLowEqualTo(Integer value) {
            addCriterion("tem_low =", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowNotEqualTo(Integer value) {
            addCriterion("tem_low <>", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowGreaterThan(Integer value) {
            addCriterion("tem_low >", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowGreaterThanOrEqualTo(Integer value) {
            addCriterion("tem_low >=", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowLessThan(Integer value) {
            addCriterion("tem_low <", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowLessThanOrEqualTo(Integer value) {
            addCriterion("tem_low <=", value, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowIn(List<Integer> values) {
            addCriterion("tem_low in", values, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowNotIn(List<Integer> values) {
            addCriterion("tem_low not in", values, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowBetween(Integer value1, Integer value2) {
            addCriterion("tem_low between", value1, value2, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemLowNotBetween(Integer value1, Integer value2) {
            addCriterion("tem_low not between", value1, value2, "temLow");
            return (Criteria) this;
        }

        public Criteria andTemHighIsNull() {
            addCriterion("tem_high is null");
            return (Criteria) this;
        }

        public Criteria andTemHighIsNotNull() {
            addCriterion("tem_high is not null");
            return (Criteria) this;
        }

        public Criteria andTemHighEqualTo(Integer value) {
            addCriterion("tem_high =", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighNotEqualTo(Integer value) {
            addCriterion("tem_high <>", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighGreaterThan(Integer value) {
            addCriterion("tem_high >", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighGreaterThanOrEqualTo(Integer value) {
            addCriterion("tem_high >=", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighLessThan(Integer value) {
            addCriterion("tem_high <", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighLessThanOrEqualTo(Integer value) {
            addCriterion("tem_high <=", value, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighIn(List<Integer> values) {
            addCriterion("tem_high in", values, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighNotIn(List<Integer> values) {
            addCriterion("tem_high not in", values, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighBetween(Integer value1, Integer value2) {
            addCriterion("tem_high between", value1, value2, "temHigh");
            return (Criteria) this;
        }

        public Criteria andTemHighNotBetween(Integer value1, Integer value2) {
            addCriterion("tem_high not between", value1, value2, "temHigh");
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