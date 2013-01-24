package com.tti.accscms.domain.clientmanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShedNoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public ShedNoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
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

        public Criteria andId2IsNull() {
            addCriterion("id2 is null");
            return (Criteria) this;
        }

        public Criteria andId2IsNotNull() {
            addCriterion("id2 is not null");
            return (Criteria) this;
        }

        public Criteria andId2EqualTo(Integer value) {
            addCriterion("id2 =", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotEqualTo(Integer value) {
            addCriterion("id2 <>", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThan(Integer value) {
            addCriterion("id2 >", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("id2 >=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThan(Integer value) {
            addCriterion("id2 <", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThanOrEqualTo(Integer value) {
            addCriterion("id2 <=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2In(List<Integer> values) {
            addCriterion("id2 in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotIn(List<Integer> values) {
            addCriterion("id2 not in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2Between(Integer value1, Integer value2) {
            addCriterion("id2 between", value1, value2, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotBetween(Integer value1, Integer value2) {
            addCriterion("id2 not between", value1, value2, "id2");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andShedNoIsNull() {
            addCriterion("shed_no is null");
            return (Criteria) this;
        }

        public Criteria andShedNoIsNotNull() {
            addCriterion("shed_no is not null");
            return (Criteria) this;
        }

        public Criteria andShedNoEqualTo(String value) {
            addCriterion("shed_no =", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoNotEqualTo(String value) {
            addCriterion("shed_no <>", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoGreaterThan(String value) {
            addCriterion("shed_no >", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoGreaterThanOrEqualTo(String value) {
            addCriterion("shed_no >=", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoLessThan(String value) {
            addCriterion("shed_no <", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoLessThanOrEqualTo(String value) {
            addCriterion("shed_no <=", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoLike(String value) {
            addCriterion("shed_no like", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoNotLike(String value) {
            addCriterion("shed_no not like", value, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoIn(List<String> values) {
            addCriterion("shed_no in", values, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoNotIn(List<String> values) {
            addCriterion("shed_no not in", values, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoBetween(String value1, String value2) {
            addCriterion("shed_no between", value1, value2, "shedNo");
            return (Criteria) this;
        }

        public Criteria andShedNoNotBetween(String value1, String value2) {
            addCriterion("shed_no not between", value1, value2, "shedNo");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNull() {
            addCriterion("modified_date is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNotNull() {
            addCriterion("modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateEqualTo(Date value) {
            addCriterion("modified_date =", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotEqualTo(Date value) {
            addCriterion("modified_date <>", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThan(Date value) {
            addCriterion("modified_date >", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_date >=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThan(Date value) {
            addCriterion("modified_date <", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("modified_date <=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIn(List<Date> values) {
            addCriterion("modified_date in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotIn(List<Date> values) {
            addCriterion("modified_date not in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateBetween(Date value1, Date value2) {
            addCriterion("modified_date between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("modified_date not between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shed_no
     *
     * @mbggenerated do_not_delete_during_merge Wed Dec 26 12:07:08 ICT 2012
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
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