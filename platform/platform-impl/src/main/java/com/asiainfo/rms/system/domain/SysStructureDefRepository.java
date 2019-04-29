package com.asiainfo.rms.system.domain;

public class SysStructureDefRepository {
    private Integer structureId;

    private String structureName;

    private String structureType;

    private Integer structureOrder;

    private Integer structureParentId;

    private String notes;

    private String structureCode;

    public Integer getStructureId() {
        return structureId;
    }

    public void setStructureId(Integer structureId) {
        this.structureId = structureId;
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public Integer getStructureOrder() {
        return structureOrder;
    }

    public void setStructureOrder(Integer structureOrder) {
        this.structureOrder = structureOrder;
    }

    public Integer getStructureParentId() {
        return structureParentId;
    }

    public void setStructureParentId(Integer structureParentId) {
        this.structureParentId = structureParentId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStructureCode() {
        return structureCode;
    }

    public void setStructureCode(String structureCode) {
        this.structureCode = structureCode;
    }
}
