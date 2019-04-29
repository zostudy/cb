package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//岗位表
public class SysStationDTO {
    private Integer stationId;//岗位主键
    private String code;//岗位编码
    private String name;//岗位名称
    private String notes;//岗位备注
    private Integer state;//状态 1：正常 0：注销
    private Integer type;//岗位类型
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
}
