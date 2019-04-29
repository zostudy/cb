package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStaffOrgRelatRepository;
import com.asiainfo.rms.system.dto.SysStaffOrgRelatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SysStaffOrgRelatConvert {
    SysStaffOrgRelatConvert INSTANCE = Mappers.getMapper(SysStaffOrgRelatConvert.class);

    SysStaffOrgRelatDTO toDTO(SysStaffOrgRelatRepository staffOrgRelatRepository);

    SysStaffOrgRelatRepository toSYS(SysStaffOrgRelatDTO staffOrgRelatDTO);

    List<SysStaffOrgRelatDTO> toDTOs(List<SysStaffOrgRelatRepository> staffOrgRelatRepositoryList);
}
