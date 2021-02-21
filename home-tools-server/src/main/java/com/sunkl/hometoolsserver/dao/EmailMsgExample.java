package com.sunkl.hometoolsserver.dao;

import java.util.ArrayList;
import java.util.List;

public class EmailMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailMsgExample() {
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

        public Criteria andEmailMsgIdIsNull() {
            addCriterion("email_msg_id is null");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdIsNotNull() {
            addCriterion("email_msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdEqualTo(Integer value) {
            addCriterion("email_msg_id =", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdNotEqualTo(Integer value) {
            addCriterion("email_msg_id <>", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdGreaterThan(Integer value) {
            addCriterion("email_msg_id >", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_msg_id >=", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdLessThan(Integer value) {
            addCriterion("email_msg_id <", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("email_msg_id <=", value, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdIn(List<Integer> values) {
            addCriterion("email_msg_id in", values, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdNotIn(List<Integer> values) {
            addCriterion("email_msg_id not in", values, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("email_msg_id between", value1, value2, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("email_msg_id not between", value1, value2, "emailMsgId");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIsNull() {
            addCriterion("src_address is null");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIsNotNull() {
            addCriterion("src_address is not null");
            return (Criteria) this;
        }

        public Criteria andSrcAddressEqualTo(String value) {
            addCriterion("src_address =", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotEqualTo(String value) {
            addCriterion("src_address <>", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressGreaterThan(String value) {
            addCriterion("src_address >", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressGreaterThanOrEqualTo(String value) {
            addCriterion("src_address >=", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLessThan(String value) {
            addCriterion("src_address <", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLessThanOrEqualTo(String value) {
            addCriterion("src_address <=", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressLike(String value) {
            addCriterion("src_address like", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotLike(String value) {
            addCriterion("src_address not like", value, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressIn(List<String> values) {
            addCriterion("src_address in", values, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotIn(List<String> values) {
            addCriterion("src_address not in", values, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressBetween(String value1, String value2) {
            addCriterion("src_address between", value1, value2, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andSrcAddressNotBetween(String value1, String value2) {
            addCriterion("src_address not between", value1, value2, "srcAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressIsNull() {
            addCriterion("target_address is null");
            return (Criteria) this;
        }

        public Criteria andTargetAddressIsNotNull() {
            addCriterion("target_address is not null");
            return (Criteria) this;
        }

        public Criteria andTargetAddressEqualTo(String value) {
            addCriterion("target_address =", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotEqualTo(String value) {
            addCriterion("target_address <>", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressGreaterThan(String value) {
            addCriterion("target_address >", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressGreaterThanOrEqualTo(String value) {
            addCriterion("target_address >=", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLessThan(String value) {
            addCriterion("target_address <", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLessThanOrEqualTo(String value) {
            addCriterion("target_address <=", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLike(String value) {
            addCriterion("target_address like", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotLike(String value) {
            addCriterion("target_address not like", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressIn(List<String> values) {
            addCriterion("target_address in", values, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotIn(List<String> values) {
            addCriterion("target_address not in", values, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressBetween(String value1, String value2) {
            addCriterion("target_address between", value1, value2, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotBetween(String value1, String value2) {
            addCriterion("target_address not between", value1, value2, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andEmailObjectIsNull() {
            addCriterion("email_object is null");
            return (Criteria) this;
        }

        public Criteria andEmailObjectIsNotNull() {
            addCriterion("email_object is not null");
            return (Criteria) this;
        }

        public Criteria andEmailObjectEqualTo(String value) {
            addCriterion("email_object =", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectNotEqualTo(String value) {
            addCriterion("email_object <>", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectGreaterThan(String value) {
            addCriterion("email_object >", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectGreaterThanOrEqualTo(String value) {
            addCriterion("email_object >=", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectLessThan(String value) {
            addCriterion("email_object <", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectLessThanOrEqualTo(String value) {
            addCriterion("email_object <=", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectLike(String value) {
            addCriterion("email_object like", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectNotLike(String value) {
            addCriterion("email_object not like", value, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectIn(List<String> values) {
            addCriterion("email_object in", values, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectNotIn(List<String> values) {
            addCriterion("email_object not in", values, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectBetween(String value1, String value2) {
            addCriterion("email_object between", value1, value2, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailObjectNotBetween(String value1, String value2) {
            addCriterion("email_object not between", value1, value2, "emailObject");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIsNull() {
            addCriterion("email_msg is null");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIsNotNull() {
            addCriterion("email_msg is not null");
            return (Criteria) this;
        }

        public Criteria andEmailMsgEqualTo(String value) {
            addCriterion("email_msg =", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgNotEqualTo(String value) {
            addCriterion("email_msg <>", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgGreaterThan(String value) {
            addCriterion("email_msg >", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgGreaterThanOrEqualTo(String value) {
            addCriterion("email_msg >=", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgLessThan(String value) {
            addCriterion("email_msg <", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgLessThanOrEqualTo(String value) {
            addCriterion("email_msg <=", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgLike(String value) {
            addCriterion("email_msg like", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgNotLike(String value) {
            addCriterion("email_msg not like", value, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgIn(List<String> values) {
            addCriterion("email_msg in", values, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgNotIn(List<String> values) {
            addCriterion("email_msg not in", values, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgBetween(String value1, String value2) {
            addCriterion("email_msg between", value1, value2, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andEmailMsgNotBetween(String value1, String value2) {
            addCriterion("email_msg not between", value1, value2, "emailMsg");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("is_send is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("is_send is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(String value) {
            addCriterion("is_send =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(String value) {
            addCriterion("is_send <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(String value) {
            addCriterion("is_send >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(String value) {
            addCriterion("is_send >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(String value) {
            addCriterion("is_send <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(String value) {
            addCriterion("is_send <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLike(String value) {
            addCriterion("is_send like", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotLike(String value) {
            addCriterion("is_send not like", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<String> values) {
            addCriterion("is_send in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<String> values) {
            addCriterion("is_send not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(String value1, String value2) {
            addCriterion("is_send between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(String value1, String value2) {
            addCriterion("is_send not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("send_time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("send_time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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