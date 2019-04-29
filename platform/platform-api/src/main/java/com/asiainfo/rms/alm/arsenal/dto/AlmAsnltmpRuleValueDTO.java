package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpRuleValueDTO {
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
}
