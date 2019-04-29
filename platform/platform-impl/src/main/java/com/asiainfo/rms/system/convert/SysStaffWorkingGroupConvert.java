package com.asiainfo.rms.system.convert;


import com.asiainfo.rms.system.domain.SysStaffWorkingGroupRepository;
import com.asiainfo.rms.system.dto.SysStaffWorkingGroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStaffWorkingGroupConvert {
    SysStaffWorkingGroupConvert INSTANCE = Mappers.getMapper(SysStaffWorkingGroupConvert.class);

    SysStaffWorkingGroupDTO toDTO(SysStaffWorkingGroupRepository staffWorkingGroupRepository);

    SysStaffWorkingGroupRepository toSYS(SysStaffWorkingGroupDTO staffWorkingGroupDTO);

    List<SysStaffWorkingGroupDTO> toDTOs(List<SysStaffWorkingGroupRepository> staffWorkingGroupRepositoryList);
}
