package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysOpTypeDefDTO {
    private Integer OpTypeId;
    private String OpTypeName;
    private String code;
    private String notes;
    private Integer state;
}
