package com.asiainfo.rms.alm.util.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
//岗位权限表
public class AlmAttachCheckConfigDTO {
    private BigDecimal attChkId;

    private BigDecimal codingType;

    private String attType;

    private String linkNo;

    private String sysTag;

    private String subsysTag;

    private String objType;

    private String mark;

    private BigDecimal status;
}
