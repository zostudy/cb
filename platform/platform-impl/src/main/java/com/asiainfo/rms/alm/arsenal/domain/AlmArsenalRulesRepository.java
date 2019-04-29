package com.asiainfo.rms.alm.arsenal.domain;

public class AlmArsenalRulesRepository {
    private Integer arId;//武器库规则主键

    private String ruleTag;//规则编码

    private String ruleName;//规则名称

    private String enumMark;//枚举值标识

    private Integer ruleType;//规则类型

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
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

    public String getEnumMark() {
        return enumMark;
    }

    public void setEnumMark(String enumMark) {
        this.enumMark = enumMark;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }
}
