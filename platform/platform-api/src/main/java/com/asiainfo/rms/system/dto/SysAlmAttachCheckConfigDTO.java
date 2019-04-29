package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysAlmAttachCheckConfigDTO {
    private Integer attChkId;

    private Integer codingType;

    private String attType;

    private String linkNo;

    private String sysTag;

    private String subsysTag;

    private String objType;

    private String mark;

    private Integer status;
}
