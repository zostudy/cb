package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlmAsnltmpChargeDTO {
    private Integer acId;//主键ID

    private String prdctName;//产品名称

    private String prdctDscr;//产品描述

    private Integer prdctBrand;//产品品牌

    private BigDecimal cardCost;//卡费（单位为分）

    private BigDecimal firstBill;//首次预存话费金额（单位为分）

    private Integer firstPassbook;//首次预存话费存折

    private String firstPbCont;//首次预存话费存折内容

    private String consultPrdct;//继承可选优惠包参照产品（6位）

    private Integer artType;//武器库模板类型

    private Integer aatId;//武器库模板主键

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private String createTime;//创建时间

    private String prdctBrandCont;//产品品牌内容
}
