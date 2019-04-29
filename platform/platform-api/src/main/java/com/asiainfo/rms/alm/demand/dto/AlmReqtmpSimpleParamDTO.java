package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpSimpleParamDTO {

    private Integer arspId;//简易参数需求模板主键

    private String objTag;//对象编码

    private String objName;//对象名称

    private Integer modifyType;//对象类型

    private String onlineTime;//上线时间

    private String offlineTime;//下线时间

    private String modifyName;//修改后名称

    private String noteBefore;//修改前注释

    private String noteAfter;//修改后注释

    private String mark;//备注信息

    private Integer artId;//需求模板主题表主键

    private Integer artType;//模板类型，简易参数修改类

    private String modifyTypeCont;//对象类型内容

    private String artTag;

    private String artName;

}
