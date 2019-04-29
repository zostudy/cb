package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysOpTypeDefRepository;
import com.asiainfo.rms.system.dto.SysOpTypeDefDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysOpTypeDefConvert {
    SysOpTypeDefConvert INSTANCE = Mappers.getMapper(SysOpTypeDefConvert.class);

    SysOpTypeDefDTO toDTO(SysOpTypeDefRepository opTypeDefRepository);

    SysOpTypeDefRepository toSYS(SysOpTypeDefDTO opTypeDefDTO);

    List<SysOpTypeDefDTO> toDTOs(List<SysOpTypeDefRepository> opTypeDefList);
}
