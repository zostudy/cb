package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysWorkingGroupRepository;
import com.asiainfo.rms.system.dto.SysWorkingGroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysWorkingGroupConvert {
    SysWorkingGroupConvert INSTANCE = Mappers.getMapper(SysWorkingGroupConvert.class);


    @Mappings({
            @Mapping(source = "createDate",target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysWorkingGroupDTO toDTO(SysWorkingGroupRepository workingGroupRepository);

    @Mappings({
            @Mapping(source = "createDate",target = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysWorkingGroupRepository toSYS(SysWorkingGroupDTO workingGroupDTO);


    List<SysWorkingGroupDTO> toDTOs(List<SysWorkingGroupRepository> workingGroupRepositoryList);
}
