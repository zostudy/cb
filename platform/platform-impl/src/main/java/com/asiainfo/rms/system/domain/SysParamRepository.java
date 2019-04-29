package com.asiainfo.rms.system.domain;

public class SysParamRepository {
    private String paramType;//参数类型
    private Integer paramId;//参数ID
    private String paramNo;//参数编号
    private String paramName;//参数名称
    private String paramDesc;//参数描述
    private Integer paramRelaId;//默认为 父关系 PARAM_ID
    private String paramValue;//参数值
    private Integer sortId;//参数排序，以sort_id的值的大小作为排次序。缺省值为0

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamNo() {
        return paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public Integer getParamRelaId() {
        return paramRelaId;
    }

    public void setParamRelaId(Integer paramRelaId) {
        this.paramRelaId = paramRelaId;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
