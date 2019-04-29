package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStaffRoleAuthorRepository;
import com.asiainfo.rms.system.dto.SysStaffRoleAuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SysStaffRoleAuthorConvert {
    SysStaffRoleAuthorConvert INSTANCE = Mappers.getMapper(SysStaffRoleAuthorConvert.class);

    SysStaffRoleAuthorDTO toDTO(SysStaffRoleAuthorRepository staffRoleAuthorRepository);

    SysStaffRoleAuthorRepository toSYS(SysStaffRoleAuthorDTO staffRoleAuthorDTO);

    List<SysStaffRoleAuthorDTO> toDTOs(List<SysStaffRoleAuthorRepository> staffRoleAuthorRepositoryList);
}
