package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStaffRepository;
import com.asiainfo.rms.system.dto.SysStaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface SysStaffConvert {
    SysStaffConvert INSTANCE = Mappers.getMapper(SysStaffConvert.class);
    @Mappings({
            @Mapping(target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysStaffDTO toDTO(SysStaffRepository staffRepository);
    @Mappings({
            @Mapping(target = "recentTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysStaffRepository toSYS(SysStaffDTO staffDTO);

    List<SysStaffDTO> toDTOs(List<SysStaffRepository> staffRepositoryList);
}
