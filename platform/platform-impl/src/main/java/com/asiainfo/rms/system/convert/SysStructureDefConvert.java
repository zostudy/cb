package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStructureDefRepository;
import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStructureDefConvert {
    SysStructureDefConvert INSTANCE = Mappers.getMapper(SysStructureDefConvert.class);

    SysStructureDefDTO toDTO(SysStructureDefRepository sysStructureDefRepository);

    SysStructureDefRepository toSYS(SysStructureDefDTO sysStructureDefDTO);

    List<SysStructureDefDTO> toDTOs(List<SysStructureDefRepository> sysStructureDefRepositoryList);
}
