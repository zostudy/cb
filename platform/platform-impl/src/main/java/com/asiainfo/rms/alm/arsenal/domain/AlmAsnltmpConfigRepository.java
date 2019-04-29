package com.asiainfo.rms.alm.arsenal.domain;

public class AlmAsnltmpConfigRepository {
    private Integer aacId;//配置表主键

    private String tbName;//对象表名

    private String updateColumn;//需更新的字段名称

    private String tableRemark;//注释说明

    private Integer artType;//模版类型

    public Integer getAacId() {
        return aacId;
    }

    public void setAacId(Integer aacId) {
        this.aacId = aacId;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getUpdateColumn() {
        return updateColumn;
    }

    public void setUpdateColumn(String updateColumn) {
        this.updateColumn = updateColumn;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }
}
