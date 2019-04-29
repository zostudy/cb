package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysParamRepository;
import com.asiainfo.rms.system.dto.SysParamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysParamConvert {
    SysParamConvert INSTANCE = Mappers.getMapper(SysParamConvert.class);

    SysParamDTO toDTO(SysParamRepository sysParamRepository);

    SysParamRepository toSYS(SysParamDTO sysParamDTO);

    List<SysParamDTO> toDTOs(List<SysParamRepository> sysParamRepositoryList);
}
