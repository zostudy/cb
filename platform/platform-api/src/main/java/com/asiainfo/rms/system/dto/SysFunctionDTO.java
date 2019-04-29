package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//功能菜单表
public class SysFunctionDTO {
    private Integer funcId;//功能菜单主键
    private String funcCode;//功能菜单编码
    private String name;//功能菜单名称
    private String notes;//功能菜单备注
    private Integer parentId;//父功能菜单id
    private Integer funSeq;//功能菜单序列
    private String viewPath;//功能菜单路径
    private String funcType;//H-html页面C-客户端界面
    private Integer state;//状态：1:正常 0:注销
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
}
