package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysAlmAttachCheckConfigRepostitory;
import com.asiainfo.rms.system.dto.SysAlmAttachCheckConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysAlmAttachCheckConfigConvert {
    SysAlmAttachCheckConfigConvert INSTANCE = Mappers.getMapper(SysAlmAttachCheckConfigConvert.class);

    SysAlmAttachCheckConfigDTO toDTO(SysAlmAttachCheckConfigRepostitory sysAlmAttachCheckConfigRepostitory);

    SysAlmAttachCheckConfigRepostitory toSYS(SysAlmAttachCheckConfigDTO sysAlmAttachCheckConfigDTO);

    List<SysAlmAttachCheckConfigDTO> toDTOs(List<SysAlmAttachCheckConfigRepostitory> sysAlmAttachCheckConfigRepostitoryList);

}
