package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysRoleRepository;
import com.asiainfo.rms.system.domain.SysStaffRepository;
import com.asiainfo.rms.system.dto.SysRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleDTO toDTO(SysRoleRepository roleRepository);

    SysRoleRepository toSYS(SysRoleDTO staffDTO);

    List<SysRoleDTO> toDTOs(List<SysRoleRepository> roleRepositoryList);
}
