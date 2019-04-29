package com.asiainfo.rms.system.domain;

import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import com.asiainfo.rms.system.dto.SysStructureInfoDTO;

public class SysStructureRepository {
    private SysStructureDefDTO structureDef;
    private SysStructureInfoDTO structureInfo;

    public SysStructureDefDTO getStructureDef() {
        return structureDef;
    }

    public void setStructureDef(SysStructureDefDTO structureDef) {
        this.structureDef = structureDef;
    }

    public SysStructureInfoDTO getStructureInfo() {
        return structureInfo;
    }

    public void setStructureInfo(SysStructureInfoDTO structureInfo) {
        this.structureInfo = structureInfo;
    }
}
