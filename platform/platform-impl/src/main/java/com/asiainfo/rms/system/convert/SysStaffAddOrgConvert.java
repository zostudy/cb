package com.asiainfo.rms.system.convert;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.asiainfo.rms.system.domain.SysStaffAddOrgRepository;
import com.asiainfo.rms.system.dto.SysStaffAddOrgDTO;

@Mapper()
public interface SysStaffAddOrgConvert {
	SysStaffAddOrgConvert INSTANCE = Mappers.getMapper(SysStaffAddOrgConvert.class);
    @Mappings({
            @Mapping(target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysStaffAddOrgDTO toDTO(SysStaffAddOrgRepository staffAddOrgRepository);
    @Mappings({
            @Mapping(target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysStaffAddOrgRepository toSYS(SysStaffAddOrgDTO staffAddOrgDTO);

    List<SysStaffAddOrgDTO> toDTOs(List<SysStaffAddOrgRepository> staffAddOrgRepositoryList);
}
