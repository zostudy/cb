package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStationDataRoleRepository {
    private Integer relId;
    private Integer stationId;
    private Integer dataRoleId;
    private Integer opId;
    private Date createDate;
    private Integer state;
    private Date endDate;

    private String name;//数据权限名称
    private String code;//数据权限编码

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getDataRoleId() {
        return dataRoleId;
    }

    public void setDataRoleId(Integer dataRoleId) {
        this.dataRoleId = dataRoleId;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
