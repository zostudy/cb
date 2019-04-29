package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStationFuncRepository {
    private Integer stationFuncRelatId;//关系主键
    private Integer stationId;//岗位主键
    private Integer funcId;//功能菜单主键
    private String notes;//备注
    private Integer state;//状态 1:正常 0:注销
    private Date createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
    private String funcCode;//功能菜单编码
    private String name;//功能菜单名称
    private Integer checked;//是否选中
    private Integer parentId;//父节点
    private Integer funcOrder;//排序

    private String operateType;//C表示新增，=D表示注销，=U表示更新

    public Integer getStationFuncRelatId() {
        return stationFuncRelatId;
    }

    public void setStationFuncRelatId(Integer stationFuncRelatId) {
        this.stationFuncRelatId = stationFuncRelatId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
