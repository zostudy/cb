package com.asiainfo.rms.alm.util.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlmAttachmentSelectDTO {
    private Long attId;

    private Long attPackId;

    private String attName;

    private String attPath;

    private String attType;

    private String attDesc;

    private String submitterTag;

    private Date submitTime;

    private String submitLink;
    
    private Long objId;

    private Long objType;
}
