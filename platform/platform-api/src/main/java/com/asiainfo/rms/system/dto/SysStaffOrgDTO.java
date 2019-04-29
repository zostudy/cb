package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysStaffOrgDTO {

    private Integer organizeId;
    private Integer parentOrganizeId;
    private String organizeName;
    private String code;
    private Integer staffTotal;
}
