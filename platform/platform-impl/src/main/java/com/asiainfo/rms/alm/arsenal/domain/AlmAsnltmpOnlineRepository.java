package com.asiainfo.rms.alm.arsenal.domain;

import java.util.Date;

public class AlmAsnltmpOnlineRepository {
    private Integer aaoId; //主键id

    private String reqTag;//需求编号

    private String state;//状态:

    private Date sendTime;//发送运营平台时间

    private Date stateBackTime;//运营回参时间

    public Integer getAaoId() {
        return aaoId;
    }

    public void setAaoId(Integer aaoId) {
        this.aaoId = aaoId;
    }

    public String getReqTag() {
        return reqTag;
    }

    public void setReqTag(String reqTag) {
        this.reqTag = reqTag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getStateBackTime() {
        return stateBackTime;
    }

    public void setStateBackTime(Date stateBackTime) {
        this.stateBackTime = stateBackTime;
    }
}
