package com.asiainfo.rms.alm.arsenal.domain;

public class AlmAsnltmpRuleValueRepository {
    private Integer aarvId;//武器库模板规则值主键

    private Integer aatId;//武器库模板主键

    private Integer artType;//武器库模板类型

    private Integer arId;//规则主键

    private Integer arSeq;//规则顺序

    private String arValue;//规则值

    private String aatTag;//武器库需求编码

    private Integer objId;//对象id

    private String ruleName;//规则名称

    private String ruleValue;//规则值（文本）

    private String operateType;//操作类型：C-新增，U-修改，D-删除

    public Integer getAarvId() {
        return aarvId;
    }

    public void setAarvId(Integer aarvId) {
        this.aarvId = aarvId;
    }

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getArSeq() {
        return arSeq;
    }

    public void setArSeq(Integer arSeq) {
        this.arSeq = arSeq;
    }

    public String getArValue() {
        return arValue;
    }

    public void setArValue(String arValue) {
        this.arValue = arValue;
    }

    public String getAatTag() {
        return aatTag;
    }

    public void setAatTag(String aatTag) {
        this.aatTag = aatTag;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}
