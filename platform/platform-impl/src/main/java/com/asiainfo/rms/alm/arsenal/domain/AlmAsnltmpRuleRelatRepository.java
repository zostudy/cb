package com.asiainfo.rms.alm.arsenal.domain;

public class AlmAsnltmpRuleRelatRepository {
    private Integer atrrId;//模板规则关系表主键

    private Integer artType;//模板类型

    private Integer arId;//规则主键

    private Integer arSeq;//规则显示顺序

    private Integer aarvId;

    private String artName;

    private String ruleTag;

    private String ruleName;

    private Integer ruleType;

    private String ruleValue;

    private Integer aatId;//武器库模板主键

    private String arValue;//规则值

    private String aatTag;//武器库需求编码

    private Integer objId;//对象id

    private String enumMark;

    public Integer getAtrrId() {
        return atrrId;
    }

    public void setAtrrId(Integer atrrId) {
        this.atrrId = atrrId;
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

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getRuleTag() {
        return ruleTag;
    }

    public void setRuleTag(String ruleTag) {
        this.ruleTag = ruleTag;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
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

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Integer getAarvId() {
        return aarvId;
    }

    public void setAarvId(Integer aarvId) {
        this.aarvId = aarvId;
    }

    public String getEnumMark() {
        return enumMark;
    }

    public void setEnumMark(String enumMark) {
        this.enumMark = enumMark;
    }
}
