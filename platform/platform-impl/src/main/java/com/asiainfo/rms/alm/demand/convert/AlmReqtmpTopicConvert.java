package com.asiainfo.rms.alm.demand.convert;


import com.asiainfo.rms.alm.demand.domain.AlmReqtmpTopicRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpTopicConvert {
    AlmReqtmpTopicConvert INSTANCE = Mappers.getMapper(AlmReqtmpTopicConvert.class);
    @Mappings({
        @Mapping(target = "askOnlineTime", dateFormat = "yyyy-MM-dd"),
        @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd")
	})
    AlmReqtmpTopicDTO toDTO(AlmReqtmpTopicRepository almReqtmpTopicRepository);
    @Mappings({
        @Mapping(target = "askOnlineTime", dateFormat = "yyyy-MM-dd"),
        @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpTopicRepository toSYS(AlmReqtmpTopicDTO almReqtmpTopicDTO);


    List<AlmReqtmpTopicDTO> toDTOs(List<AlmReqtmpTopicRepository> almReqtmpTopicRepositoryList);
}
