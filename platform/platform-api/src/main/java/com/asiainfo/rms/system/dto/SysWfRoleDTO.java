package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysWfRoleDTO {
    private Integer wfRoleId;
    private Integer wfId;
    private String name;
    private String code;
    private String notes;
    private Integer linkId;
    private Integer opId;
    private String createDate;
    private Integer state;
    private String processKey;
}
