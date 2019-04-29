package com.asiainfo.rms.alm.demand.domain;

public class AlmReqtmpRewardCntRepository {
    private Integer contentId;//酬金规则ID

    private String projectType;//项目类型

    private String rewardName;//酬金/渠道名称

    private String issuePeriod;//核发周期

    private Integer arrId;//酬金类模版ID

    private String ruleValidity;//酬金规则有效期

    private String formula;//计算公式

    private String upperLimit;//上限标准

    private String issueCondition;//核发条件/其他说明

    private String reportColumn;//报表字段说明

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getIssuePeriod() {
        return issuePeriod;
    }

    public void setIssuePeriod(String issuePeriod) {
        this.issuePeriod = issuePeriod;
    }

    public Integer getArrId() {
        return arrId;
    }

    public void setArrId(Integer arrId) {
        this.arrId = arrId;
    }

    public String getRuleValidity() {
        return ruleValidity;
    }

    public void setRuleValidity(String ruleValidity) {
        this.ruleValidity = ruleValidity;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getIssueCondition() {
        return issueCondition;
    }

    public void setIssueCondition(String issueCondition) {
        this.issueCondition = issueCondition;
    }

    public String getReportColumn() {
        return reportColumn;
    }

    public void setReportColumn(String reportColumn) {
        this.reportColumn = reportColumn;
    }
}
