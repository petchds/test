package com.tti.accscms.domain.clientmanagement;

import java.util.Date;

public class RequestLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column request_log.id
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column request_log.id2
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    private Integer id2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column request_log.username
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column request_log.nonce
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    private String nonce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column request_log.create_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    private Date createDateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column request_log.id
     *
     * @return the value of request_log.id
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column request_log.id
     *
     * @param id the value for request_log.id
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column request_log.id2
     *
     * @return the value of request_log.id2
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public Integer getId2() {
        return id2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column request_log.id2
     *
     * @param id2 the value for request_log.id2
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column request_log.username
     *
     * @return the value of request_log.username
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column request_log.username
     *
     * @param username the value for request_log.username
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column request_log.nonce
     *
     * @return the value of request_log.nonce
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column request_log.nonce
     *
     * @param nonce the value for request_log.nonce
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column request_log.create_date_time
     *
     * @return the value of request_log.create_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public Date getCreateDateTime() {
        return createDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column request_log.create_date_time
     *
     * @param createDateTime the value for request_log.create_date_time
     *
     * @mbggenerated Wed Dec 26 12:07:08 ICT 2012
     */
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}