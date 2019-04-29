package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysFunctionRepository;
import com.asiainfo.rms.system.dto.SysFunctionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SysFunction {

    SysFunction INSTANCE = Mappers.getMapper(SysFunction.class);

    SysFunctionDTO toDTO(SysFunctionRepository functionRepository);

    SysFunctionRepository toSYS(SysFunctionDTO functionDTO);

    List<SysFunctionDTO> toDTOs(List<SysFunctionRepository> functionRepositoryList);
}
