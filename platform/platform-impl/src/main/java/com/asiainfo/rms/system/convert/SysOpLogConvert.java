package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysOpLogRepository;
import com.asiainfo.rms.system.dto.SysOpLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysOpLogConvert {

    SysOpLogConvert INSTANCE = Mappers.getMapper(SysOpLogConvert.class);

    @Mappings({
            @Mapping(target = "opDate", dateFormat = "yyyy-MM-dd")
    })
    SysOpLogDTO toDTO(SysOpLogRepository sysOpLogRepository);
    @Mappings({
            @Mapping(target = "opDate", dateFormat = "yyyy-MM-dd")
    })

    SysOpLogRepository toSYS(SysOpLogDTO sysOpLogDTO);

    List<SysOpLogDTO> toDTOs(List<SysOpLogRepository> sysOpLogRepositoryList);
}
