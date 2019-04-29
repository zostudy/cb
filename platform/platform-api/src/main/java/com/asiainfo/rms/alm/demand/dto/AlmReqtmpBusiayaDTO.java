package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpBusiayaDTO {
    private Integer arbaId;//经分类模板主键

    private Integer dataShare;//数据共享

    private Integer displayMode;//展现模式

    private String reportName;//报表名称

    private String reportPurpose;//报表用途

    private String reportUsers;//报表用户

    private String invovleSystem;//涉及系统

    private String busiReq;//进行过业务需求

    private String communicate;//沟通

    private String reportPath;//报表添加路径

    private String timescaleReq;//统计的时间周期需求

    private String runTime;//运行时间要求

    private String dataArea;//提取的数据区域

    private String dataHisUpdate;//历史数据更新要求

    private String savePeriod;//数据保存周期

    private String applyTimeStart;//应用生命周期开始时间

    private Integer artType;//模板类型，经分类

    private Integer artId;//需求模板主题表主键

    private String applyTimeEnd;//应用生命周期结束时间

    private String dataShareCont;//数据共享内容

    private String displayModeCont;//展现模式内容

    private String searchCondition;//检索条件

    private String removal;//剔重

    private String graphInterface;//图形界面说明

    private String exportDemond;//导出要求

    private String permDemond;//权限要求

    private String useDemond;//界面易用性要求

    private String otherContent;//其他要求

    private String graphCont;//图形界面说明文字


    private String artTag;

    private String artName;
}
