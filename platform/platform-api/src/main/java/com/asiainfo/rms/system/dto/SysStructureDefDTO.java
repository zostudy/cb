package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysStructureDefDTO {

    private Integer structureId;

    private String structureName;

    private String structureType;

    private Integer structureOrder;

    private Integer structureParentId;

    private String notes;

    private String structureCode;
}
