package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpOnlineDTO {
    private Integer aaoId; //主键id

    private String reqTag;//需求编号

    private String state;//状态:

    private String sendTime;//发送运营平台时间

    private String stateBackTime;//运营回参时间
}
