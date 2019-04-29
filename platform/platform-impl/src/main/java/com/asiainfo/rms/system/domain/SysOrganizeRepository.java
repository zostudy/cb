package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysOrganizeRepository {
    private Integer organizeId;//组织ID

    private Integer parentOrganizeId;//父组织ID

    private String organizeName;//组织名称

    private String code;//组织编码

    private String parentCode;//父组织编码

    private Integer orgType;//组织类型

    private String notes;//备注

    private Integer state;//状态 1:有效 0：删除

    private Date createDate;//创建时间

    private String ext1;//扩展字段1

    private String ext2;//扩展字段2

    private String ext3;//扩展字段3

    private Integer childrenCount;//子节点数量


    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    public Integer getParentOrganizeId() {
        return parentOrganizeId;
    }

    public void setParentOrganizeId(Integer parentOrganizeId) {
        this.parentOrganizeId = parentOrganizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }
}
