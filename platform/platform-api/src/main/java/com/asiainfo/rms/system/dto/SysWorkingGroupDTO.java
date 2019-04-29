package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysWorkingGroupDTO {
    private Integer WorkGroupId;
    private String WorkGroupName;
    private String notes;
    private Integer state;
    private String createDate;
    private Integer OpId;
    private String code;
}
