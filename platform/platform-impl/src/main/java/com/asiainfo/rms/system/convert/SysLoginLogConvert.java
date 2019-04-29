package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysLoginLogRepository;
import com.asiainfo.rms.system.dto.SysLoginLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysLoginLogConvert {
    SysLoginLogConvert INSTANCE = Mappers.getMapper(SysLoginLogConvert.class);
    @Mappings({
            @Mapping(target = "loginDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "logoutDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysLoginLogDTO toDTO(SysLoginLogRepository loginLogRepository);

    @Mappings({
            @Mapping(target = "loginDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "logoutDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    SysLoginLogRepository toSYS(SysLoginLogDTO loginLogDTO);

    List<SysLoginLogDTO> toDTOs(List<SysLoginLogRepository> loginLogRepository);
}
