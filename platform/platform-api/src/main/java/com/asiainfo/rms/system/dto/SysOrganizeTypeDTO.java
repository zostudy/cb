package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysOrganizeTypeDTO {
    private Integer organizeTypeId;
    private String organizeTypeName;
    private String code;
    private String notes;
    private Integer opId;
    private String createDate;
    private Integer state;
}
