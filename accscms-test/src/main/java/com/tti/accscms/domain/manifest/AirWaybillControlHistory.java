package com.tti.accscms.domain.manifest;

import java.util.Date;

public class AirWaybillControlHistory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.id2
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer id2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.abil_control_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer abilControlId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.reference_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String referenceNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.received_control_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String receivedControlNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.mawb
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String mawb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.freight_forwarder_tax_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String freightForwarderTaxNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.freight_forwarder_branch
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer freightForwarderBranch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.processing_indicator
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String processingIndicator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.origin_country_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String originCountryCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.port_of_loading
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String portOfLoading;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.port_of_discharge
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String portOfDischarge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.place_of_receipt
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String placeOfReceipt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.place_of_delivery
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String placeOfDelivery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer shedNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.message_function
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String messageFunction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.freight_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String freightCharges;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.other_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String otherCharges;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.freight_amount_foreign
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Double freightAmountForeign;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.freight_currency_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String freightCurrencyCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.term_of_payment_freight
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String termOfPaymentFreight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.registration_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private String registrationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.modified_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Date modifiedDateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column abil_control_his.type
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.id
     *
     * @return the value of abil_control_his.id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.id
     *
     * @param id the value for abil_control_his.id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.id2
     *
     * @return the value of abil_control_his.id2
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getId2() {
        return id2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.id2
     *
     * @param id2 the value for abil_control_his.id2
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.abil_control_id
     *
     * @return the value of abil_control_his.abil_control_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getAbilControlId() {
        return abilControlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.abil_control_id
     *
     * @param abilControlId the value for abil_control_his.abil_control_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setAbilControlId(Integer abilControlId) {
        this.abilControlId = abilControlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.reference_number
     *
     * @return the value of abil_control_his.reference_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.reference_number
     *
     * @param referenceNumber the value for abil_control_his.reference_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.received_control_number
     *
     * @return the value of abil_control_his.received_control_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getReceivedControlNumber() {
        return receivedControlNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.received_control_number
     *
     * @param receivedControlNumber the value for abil_control_his.received_control_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setReceivedControlNumber(String receivedControlNumber) {
        this.receivedControlNumber = receivedControlNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.mawb
     *
     * @return the value of abil_control_his.mawb
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getMawb() {
        return mawb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.mawb
     *
     * @param mawb the value for abil_control_his.mawb
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.freight_forwarder_tax_number
     *
     * @return the value of abil_control_his.freight_forwarder_tax_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getFreightForwarderTaxNumber() {
        return freightForwarderTaxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.freight_forwarder_tax_number
     *
     * @param freightForwarderTaxNumber the value for abil_control_his.freight_forwarder_tax_number
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setFreightForwarderTaxNumber(String freightForwarderTaxNumber) {
        this.freightForwarderTaxNumber = freightForwarderTaxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.freight_forwarder_branch
     *
     * @return the value of abil_control_his.freight_forwarder_branch
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getFreightForwarderBranch() {
        return freightForwarderBranch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.freight_forwarder_branch
     *
     * @param freightForwarderBranch the value for abil_control_his.freight_forwarder_branch
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setFreightForwarderBranch(Integer freightForwarderBranch) {
        this.freightForwarderBranch = freightForwarderBranch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.processing_indicator
     *
     * @return the value of abil_control_his.processing_indicator
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getProcessingIndicator() {
        return processingIndicator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.processing_indicator
     *
     * @param processingIndicator the value for abil_control_his.processing_indicator
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setProcessingIndicator(String processingIndicator) {
        this.processingIndicator = processingIndicator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.origin_country_code
     *
     * @return the value of abil_control_his.origin_country_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getOriginCountryCode() {
        return originCountryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.origin_country_code
     *
     * @param originCountryCode the value for abil_control_his.origin_country_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setOriginCountryCode(String originCountryCode) {
        this.originCountryCode = originCountryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.port_of_loading
     *
     * @return the value of abil_control_his.port_of_loading
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getPortOfLoading() {
        return portOfLoading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.port_of_loading
     *
     * @param portOfLoading the value for abil_control_his.port_of_loading
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.port_of_discharge
     *
     * @return the value of abil_control_his.port_of_discharge
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.port_of_discharge
     *
     * @param portOfDischarge the value for abil_control_his.port_of_discharge
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.place_of_receipt
     *
     * @return the value of abil_control_his.place_of_receipt
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getPlaceOfReceipt() {
        return placeOfReceipt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.place_of_receipt
     *
     * @param placeOfReceipt the value for abil_control_his.place_of_receipt
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setPlaceOfReceipt(String placeOfReceipt) {
        this.placeOfReceipt = placeOfReceipt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.place_of_delivery
     *
     * @return the value of abil_control_his.place_of_delivery
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.place_of_delivery
     *
     * @param placeOfDelivery the value for abil_control_his.place_of_delivery
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.shed_no
     *
     * @return the value of abil_control_his.shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getShedNo() {
        return shedNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.shed_no
     *
     * @param shedNo the value for abil_control_his.shed_no
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setShedNo(Integer shedNo) {
        this.shedNo = shedNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.message_function
     *
     * @return the value of abil_control_his.message_function
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getMessageFunction() {
        return messageFunction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.message_function
     *
     * @param messageFunction the value for abil_control_his.message_function
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setMessageFunction(String messageFunction) {
        this.messageFunction = messageFunction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.freight_charges
     *
     * @return the value of abil_control_his.freight_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getFreightCharges() {
        return freightCharges;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.freight_charges
     *
     * @param freightCharges the value for abil_control_his.freight_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setFreightCharges(String freightCharges) {
        this.freightCharges = freightCharges;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.other_charges
     *
     * @return the value of abil_control_his.other_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getOtherCharges() {
        return otherCharges;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.other_charges
     *
     * @param otherCharges the value for abil_control_his.other_charges
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setOtherCharges(String otherCharges) {
        this.otherCharges = otherCharges;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.freight_amount_foreign
     *
     * @return the value of abil_control_his.freight_amount_foreign
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Double getFreightAmountForeign() {
        return freightAmountForeign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.freight_amount_foreign
     *
     * @param freightAmountForeign the value for abil_control_his.freight_amount_foreign
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setFreightAmountForeign(Double freightAmountForeign) {
        this.freightAmountForeign = freightAmountForeign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.freight_currency_code
     *
     * @return the value of abil_control_his.freight_currency_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getFreightCurrencyCode() {
        return freightCurrencyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.freight_currency_code
     *
     * @param freightCurrencyCode the value for abil_control_his.freight_currency_code
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setFreightCurrencyCode(String freightCurrencyCode) {
        this.freightCurrencyCode = freightCurrencyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.term_of_payment_freight
     *
     * @return the value of abil_control_his.term_of_payment_freight
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getTermOfPaymentFreight() {
        return termOfPaymentFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.term_of_payment_freight
     *
     * @param termOfPaymentFreight the value for abil_control_his.term_of_payment_freight
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setTermOfPaymentFreight(String termOfPaymentFreight) {
        this.termOfPaymentFreight = termOfPaymentFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.registration_id
     *
     * @return the value of abil_control_his.registration_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.registration_id
     *
     * @param registrationId the value for abil_control_his.registration_id
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.modified_date_time
     *
     * @return the value of abil_control_his.modified_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.modified_date_time
     *
     * @param modifiedDateTime the value for abil_control_his.modified_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column abil_control_his.type
     *
     * @return the value of abil_control_his.type
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column abil_control_his.type
     *
     * @param type the value for abil_control_his.type
     *
     * @mbggenerated Wed Dec 26 12:07:04 ICT 2012
     */
    public void setType(Integer type) {
        this.type = type;
    }
}