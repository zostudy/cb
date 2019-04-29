package com.asiainfo.rms.alm.arsenal.domain;

import java.util.Date;

public class AlmAsnltmpLabelConfigRepository {
    private Integer lmId;//标签信息id

    private String labelName;//标签名称

    private Integer artType;//所属模板类型

    private Date createTime;//创建时间

    private Integer createPersonId;//创建人id

    private String createPersonName;//创建人名称

    private Integer useTimes;//使用次数

    private Integer queryType;//查询类型

    private Integer exportTag;//导出标签

    public Integer getLmId() {
        return lmId;
    }

    public void setLmId(Integer lmId) {
        this.lmId = lmId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Integer createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Integer getExportTag() {
        return exportTag;
    }

    public void setExportTag(Integer exportTag) {
        this.exportTag = exportTag;
    }
}
