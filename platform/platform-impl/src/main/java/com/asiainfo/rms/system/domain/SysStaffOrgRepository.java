package com.asiainfo.rms.system.domain;

public class SysStaffOrgRepository {

    private Integer organizeId;
    private Integer parentOrganizeId;
    private String organizeName;
    private String code;
    private Integer staffTotal;

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

    public Integer getStaffTotal() {
        return staffTotal;
    }

    public void setStaffTotal(Integer staffTotal) {
        this.staffTotal = staffTotal;
    }

    @Override
    public String toString() {
        return "SysStaffOrgRepository{" +
                "organizeId=" + organizeId +
                ", parentOrganizeId=" + parentOrganizeId +
                ", organizeName='" + organizeName + '\'' +
                ", code='" + code + '\'' +
                ", staffTotal=" + staffTotal +
                '}';
    }
}
