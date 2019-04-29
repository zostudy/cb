package com.asiainfo.rms.alm.util.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AlmAttachmentDTO {
    private Long attId;

    private String attName;

    private String attPath;

    private String attType;

    private String attDesc;

    private String submitterTag;

    private Date submitTime;

    private String submitLink;
}
