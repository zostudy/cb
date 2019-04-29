package com.asiainfo.rms.workflow.dto.common;

import lombok.Data;

import java.util.Date;

@Data
public class WorkflowOrderDto {
    private Integer orderId;
    private Integer objId;
    private String objType;
    private String objTag;
    private String objName;
    private String vmTaskName;
    private String linkNo;
    private Integer linkId;
    private Integer execStaffId;
    private String code;
    private String employeeName;
    private Date createTime;
    private Date finishTime;
    private String orderType;
    private String cond;
    private String result;
    private String status;
    private String opinion;
    private String nextLinkPlantime;
    private Integer last_orderId;
    private String accred;
    private String remineTime;
    private String phaseId;
    private String codingType;
    private Integer timeConsum;
    private String submitstaffname;
    private String resstaffname;
    private Date orderDate;
    private Date proposeDate;
}

