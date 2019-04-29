package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysOpLogDTO {
    private Integer opLogId;
    private Integer opTypeId;
    private String opContent;
    private Integer opId;
    private String opDate;
}
