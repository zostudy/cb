package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlmAsnltmpStoreGiveDTO {
    private Integer aasId;//存送主表主键

    private String marketPrdctName;//营销产品名称

    private String cityNum;//地市编码

    private String marketPrdctDscr;//营销产品描述

    private String startTime;//活动开始时间

    private String endTime;//活动结束时间

    private String createTime;//创建时间

    private String marketPackName;//营销包名称

    private String marketPackDscr;//营销包描述

    private Integer contractPeriod;//合约期

    private Integer effecWay;//活动生效方式

    private BigDecimal preBill;//预存话费档次

    private BigDecimal monthBill;//分月话费

    private Integer monthPassbook;//分月话费存折

    private BigDecimal freeBill;//自由话费

    private Integer freePassbook;//自由话费存折

    private BigDecimal monthArriv;//预存话费分月到账

    private BigDecimal baseConsump;//保底消费

    private Integer baseConspCount;//保底消费账目编码

    private Integer prioLevel;//优先级设定

    private String benifitEffort;//优惠力度

    private String effecWayCont;//活动生效方式内容

    private String monthPassbookCont;//分月话费存折内容

    private String freePassbookCont;//自由话费存折内容

    private String baseConspCountCont;//保底消费账目编码内容

    private String prioLevelCont;//优先级设定内容

    private Integer artType;//武器库模板类型

    private Integer aatId;//武器库模板主键

    private String cityNumCont;//地市编码内容

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败
}
