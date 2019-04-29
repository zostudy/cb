package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStructureInfoRepository;
import com.asiainfo.rms.system.dto.SysStructureInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStructureInfoConvert {
    SysStructureInfoConvert INSTANCE = Mappers.getMapper(SysStructureInfoConvert.class);

    SysStructureInfoDTO toDTO(SysStructureInfoRepository sysStructureInfoRepository);

    SysStructureInfoRepository toSYS(SysStructureInfoDTO sysStructureInfoDTO);

    List<SysStructureInfoDTO> toDTOs(List<SysStructureInfoRepository> sysStructureInfoRepositoryList);
}
