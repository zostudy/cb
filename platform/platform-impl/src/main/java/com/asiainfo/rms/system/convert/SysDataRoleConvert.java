package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysDataRoleRepostitory;
import com.asiainfo.rms.system.dto.SysDataRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysDataRoleConvert {
    SysDataRoleConvert INSTANCE = Mappers.getMapper(SysDataRoleConvert.class);

    SysDataRoleDTO toDTO(SysDataRoleRepostitory dataRoleRepostitory);

    SysDataRoleRepostitory toSYS(SysDataRoleDTO dataRoleDTO);

    List<SysDataRoleDTO> toDTOs(List<SysDataRoleRepostitory> dataRoleRepostitoryList);
}
