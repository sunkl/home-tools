package com.sunkl.hometoolsserver.dao;

import java.util.ArrayList;
import java.util.List;

public class EmailSendConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailSendConfigExample() {
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

        public Criteria andEmailSendConfigIdIsNull() {
            addCriterion("email_send_config_id is null");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdIsNotNull() {
            addCriterion("email_send_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdEqualTo(Integer value) {
            addCriterion("email_send_config_id =", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdNotEqualTo(Integer value) {
            addCriterion("email_send_config_id <>", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdGreaterThan(Integer value) {
            addCriterion("email_send_config_id >", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_send_config_id >=", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdLessThan(Integer value) {
            addCriterion("email_send_config_id <", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("email_send_config_id <=", value, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdIn(List<Integer> values) {
            addCriterion("email_send_config_id in", values, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdNotIn(List<Integer> values) {
            addCriterion("email_send_config_id not in", values, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("email_send_config_id between", value1, value2, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andEmailSendConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("email_send_config_id not between", value1, value2, "emailSendConfigId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("item_type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("item_type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(String value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(String value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(String value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(String value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(String value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(String value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLike(String value) {
            addCriterion("condition like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotLike(String value) {
            addCriterion("condition not like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<String> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<String> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(String value1, String value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(String value1, String value2) {
            addCriterion("condition not between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andDateRangeIsNull() {
            addCriterion("date_range is null");
            return (Criteria) this;
        }

        public Criteria andDateRangeIsNotNull() {
            addCriterion("date_range is not null");
            return (Criteria) this;
        }

        public Criteria andDateRangeEqualTo(String value) {
            addCriterion("date_range =", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeNotEqualTo(String value) {
            addCriterion("date_range <>", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeGreaterThan(String value) {
            addCriterion("date_range >", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeGreaterThanOrEqualTo(String value) {
            addCriterion("date_range >=", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeLessThan(String value) {
            addCriterion("date_range <", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeLessThanOrEqualTo(String value) {
            addCriterion("date_range <=", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeLike(String value) {
            addCriterion("date_range like", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeNotLike(String value) {
            addCriterion("date_range not like", value, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeIn(List<String> values) {
            addCriterion("date_range in", values, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeNotIn(List<String> values) {
            addCriterion("date_range not in", values, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeBetween(String value1, String value2) {
            addCriterion("date_range between", value1, value2, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeNotBetween(String value1, String value2) {
            addCriterion("date_range not between", value1, value2, "dateRange");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameIsNull() {
            addCriterion("date_range_col_name is null");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameIsNotNull() {
            addCriterion("date_range_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameEqualTo(String value) {
            addCriterion("date_range_col_name =", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameNotEqualTo(String value) {
            addCriterion("date_range_col_name <>", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameGreaterThan(String value) {
            addCriterion("date_range_col_name >", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameGreaterThanOrEqualTo(String value) {
            addCriterion("date_range_col_name >=", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameLessThan(String value) {
            addCriterion("date_range_col_name <", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameLessThanOrEqualTo(String value) {
            addCriterion("date_range_col_name <=", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameLike(String value) {
            addCriterion("date_range_col_name like", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameNotLike(String value) {
            addCriterion("date_range_col_name not like", value, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameIn(List<String> values) {
            addCriterion("date_range_col_name in", values, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameNotIn(List<String> values) {
            addCriterion("date_range_col_name not in", values, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameBetween(String value1, String value2) {
            addCriterion("date_range_col_name between", value1, value2, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andDateRangeColNameNotBetween(String value1, String value2) {
            addCriterion("date_range_col_name not between", value1, value2, "dateRangeColName");
            return (Criteria) this;
        }

        public Criteria andItemMessageIsNull() {
            addCriterion("item_message is null");
            return (Criteria) this;
        }

        public Criteria andItemMessageIsNotNull() {
            addCriterion("item_message is not null");
            return (Criteria) this;
        }

        public Criteria andItemMessageEqualTo(String value) {
            addCriterion("item_message =", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageNotEqualTo(String value) {
            addCriterion("item_message <>", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageGreaterThan(String value) {
            addCriterion("item_message >", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageGreaterThanOrEqualTo(String value) {
            addCriterion("item_message >=", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageLessThan(String value) {
            addCriterion("item_message <", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageLessThanOrEqualTo(String value) {
            addCriterion("item_message <=", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageLike(String value) {
            addCriterion("item_message like", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageNotLike(String value) {
            addCriterion("item_message not like", value, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageIn(List<String> values) {
            addCriterion("item_message in", values, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageNotIn(List<String> values) {
            addCriterion("item_message not in", values, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageBetween(String value1, String value2) {
            addCriterion("item_message between", value1, value2, "itemMessage");
            return (Criteria) this;
        }

        public Criteria andItemMessageNotBetween(String value1, String value2) {
            addCriterion("item_message not between", value1, value2, "itemMessage");
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