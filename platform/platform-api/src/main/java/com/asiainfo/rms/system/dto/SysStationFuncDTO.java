package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//岗位功能菜单表
public class SysStationFuncDTO {
    private Integer stationFuncRelatId;//关系主键
    private Integer stationId;//岗位主键
    private Integer funcId;//功能菜单主键
    private String notes;//备注
    private Integer state;//状态 1:正常 0:注销
    private String createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
    private String funcCode;//功能菜单编码
    private String name;//功能菜单名称
    private Integer checked;//是否选中
    private Integer parentId;//父节点
    private String operateType;//C表示新增，=D表示注销，=U表示更新

}
