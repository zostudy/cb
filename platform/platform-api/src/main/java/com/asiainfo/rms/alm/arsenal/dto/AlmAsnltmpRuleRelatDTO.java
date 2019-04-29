package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpRuleRelatDTO {
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
}
