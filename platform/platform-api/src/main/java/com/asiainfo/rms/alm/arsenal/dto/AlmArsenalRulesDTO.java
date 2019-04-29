package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmArsenalRulesDTO {
    private Integer arId;//武器库规则主键

    private String ruleTag;//规则编码

    private String ruleName;//规则名称

    private String enumMark;//枚举值标识

    private Integer ruleType;//规则类型
}
