package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysOrganizeRepository;
import com.asiainfo.rms.system.dto.SysOrganizeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SysOrganizeConvert {
    SysOrganizeConvert INSTANCE = Mappers.getMapper(SysOrganizeConvert.class);
    @Mappings({
            @Mapping(target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysOrganizeDTO toDTO(SysOrganizeRepository organizeRepository);
    @Mappings({
            @Mapping(target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    SysOrganizeRepository toSYS(SysOrganizeDTO organizeDTO);


    List<SysOrganizeDTO> toDTOs(List<SysOrganizeRepository> organizeRepositoryList);
}
