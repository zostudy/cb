package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysOrganizeTypeRepository;
import com.asiainfo.rms.system.dto.SysOrganizeTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysOrganizeTypeConvert {

    SysOrganizeTypeConvert INSTANCE = Mappers.getMapper(SysOrganizeTypeConvert.class);

    @Mappings({
            @Mapping(source = "createDate",target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    SysOrganizeTypeDTO toDTO(SysOrganizeTypeRepository organizeTypeRepository);

    @Mappings({
            @Mapping(source = "createDate",target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    SysOrganizeTypeRepository toSYS(SysOrganizeTypeDTO organizeTypeDTO);

    List<SysOrganizeTypeDTO> toDTOs(List<SysOrganizeTypeRepository> organizeTypeRepositoryList);
}
