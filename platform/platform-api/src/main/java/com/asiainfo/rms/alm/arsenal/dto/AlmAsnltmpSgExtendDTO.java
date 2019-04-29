package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlmAsnltmpSgExtendDTO {
    private Integer aasId;//存送类模板附表主键

    private Integer artType;//模板类型

    private Integer givePoint;//赠送积分

    private Integer giveTimeType1;//赠送时长类别1

    private String giveTimetypeCont1;//赠送时长类别1内容

    private BigDecimal giveTimeAmount1;//赠送时长类别1额度（分钟）

    private Integer giveTimeContract1;//赠送时长类别1合约期

    private BigDecimal monthTimeBack1;//赠送时长类别1分月到账（分钟）

    private Integer giveTimeType2;//赠送时长类别2

    private String giveTimetypeCont2;//赠送时长类别2内容

    private BigDecimal giveTimeAmount2;//赠送时长类别2额度（分钟）

    private Integer giveTimeContract2;//赠送时长类别2合约期

    private BigDecimal monthTimeBack2;//赠送时长类别2分月到账（分钟）

    private Integer giveTrafficType1;//赠送流量类别1

    private String giveTrafctypeCont1;//赠送流量类别1内容

    private BigDecimal giveTrafficAmount1;//赠送流量类别1额度（M）

    private Integer giveTrafficContract1;//赠送流量类别1合约期

    private BigDecimal monthTrafficBack1;//赠送流量类别1分月到账（M）

    private Integer giveTrafficType2;//赠送流量类别2

    private String giveTrafctypeCont2;//赠送流量类别2内容

    private BigDecimal giveTrafficAmount2;//赠送流量类别2额度（M）

    private Integer giveTrafficContract2;//赠送流量类别2合约期

    private BigDecimal monthTrafficBack2;//赠送流量类别2分月到账（M）

    private Integer giveTrafficType3;//赠送流量类别3

    private String giveTrafctypeCont3;//赠送流量类别3内容

    private BigDecimal giveTrafficAmount3;//赠送流量类别3额度（M）

    private Integer giveTrafficContract3;//赠送流量类别3合约期

    private BigDecimal monthTrafficBack3;//赠送流量类别3分月到账（M）

    private BigDecimal giveBill;//赠送话费

    private Integer giveBillContract;//赠送话费合约期

    private BigDecimal giveBillAmount;//赠送话费分月到账

    private Integer giveBillPassbook;//赠送话费存折

    private String giveBillpbCont;//赠送话费存折内容

    private String giveElecoupNum;//电子券批次号

    private BigDecimal giveElecoup;//赠送电子券

    private BigDecimal givePointPrice;//赠送积分价值

    private Integer aatId;//武器库模板主键

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

}
