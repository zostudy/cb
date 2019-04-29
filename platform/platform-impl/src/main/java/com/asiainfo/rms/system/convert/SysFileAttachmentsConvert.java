package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysFileAttachmentsRepostitory;
import com.asiainfo.rms.system.dto.SysFileAttachmentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysFileAttachmentsConvert {
    SysFileAttachmentsConvert INSTANCE = Mappers.getMapper(SysFileAttachmentsConvert.class);

    SysFileAttachmentsDTO toDTO(SysFileAttachmentsRepostitory sysFileAttachmentsRepostitory);

    SysFileAttachmentsRepostitory toSYS(SysFileAttachmentsDTO sysFileAttachmentsDTO);

    List<SysFileAttachmentsDTO> toDTOs(List<SysFileAttachmentsRepostitory> sysFileAttachmentsRepostitoryList);
}
