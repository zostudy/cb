package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStructureRepository;
import com.asiainfo.rms.system.dto.SysStructureDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SysStructureConvert {
    SysStructureConvert INSTANCE = Mappers.getMapper(SysStructureConvert.class);

    SysStructureDTO toDTO(SysStructureRepository sysStructureRepository);

    SysStructureRepository toSYS(SysStructureDTO sysStructureDefDTO);

    List<SysStructureDTO> toDTOs(List<SysStructureRepository> sysStructureRepositoryList);
}
