package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysStationDataRoleDTO {
    private Integer relId;
    private Integer stationId;
    private Integer dataRoleId;
    private Integer opId;
    private String createDate;

    private String name;//数据权限名称
    private String code;//数据权限编码
}
