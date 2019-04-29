package com.asiainfo.rms.system.domain;

import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import com.asiainfo.rms.system.dto.SysStructureInfoDTO;

import java.util.List;

public class SysStructureListRepository {
    private List<SysStructureDefDTO> structureDef;
    private List<SysStructureInfoDTO> structureInfo;

    public List<SysStructureDefDTO> getStructureDef() {
        return structureDef;
    }

    public void setStructureDef(List<SysStructureDefDTO> structureDef) {
        this.structureDef = structureDef;
    }

    public List<SysStructureInfoDTO> getStructureInfo() {
        return structureInfo;
    }

    public void setStructureInfo(List<SysStructureInfoDTO> structureInfo) {
        this.structureInfo = structureInfo;
    }
}
