package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysWfRoleRepository;
import com.asiainfo.rms.system.dto.SysWfRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysWfRoleConvert {

    SysWfRoleConvert INSTANCE = Mappers.getMapper(SysWfRoleConvert.class);

    SysWfRoleDTO toDTO(SysWfRoleRepository wfRoleRepository);

    SysWfRoleRepository toSYS(SysWfRoleDTO wfRoleDTO);

    List<SysWfRoleDTO> toDTOs(List<SysWfRoleRepository> wfRoleRepositoryList);
}
