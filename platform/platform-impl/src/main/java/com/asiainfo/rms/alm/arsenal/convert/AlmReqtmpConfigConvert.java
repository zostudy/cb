package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpTopicRepository;
import com.asiainfo.rms.alm.arsenal.domain.AlmReqtmpConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmReqtmpConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpConfigConvert {
    AlmReqtmpConfigConvert INSTANCE = Mappers.getMapper(AlmReqtmpConfigConvert.class);

    AlmReqtmpConfigDTO toDTO(AlmReqtmpConfigRepository almReqtmpConfigRepository);

    AlmReqtmpConfigRepository toSYS(AlmReqtmpConfigDTO almReqtmpConfigDTO);

    List<AlmReqtmpConfigDTO> toDTOs(List<AlmReqtmpConfigRepository> almReqtmpConfigRepositories);
}
