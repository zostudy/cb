package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStaffAddOrgRepository;
import com.asiainfo.rms.system.domain.SysStaffOrgRepository;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;
import com.asiainfo.rms.system.dto.SysStaffOrgDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
    public interface SysStaffOrgConvert {
	SysStaffOrgConvert INSTANCE = Mappers.getMapper(SysStaffOrgConvert.class);


    SysStaffOrgDTO toDTO(SysStaffOrgRepository staffOrgRepository);


    SysStaffOrgRepository toSYS(SysStaffOrgDTO staffOrgDTO);

    List<SysStaffOrgDTO> toDTOs(List<SysStaffOrgRepository> staffOrgRepositoryList);
}
