package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpTopicRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpTopicDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpTopicConvert {
    AlmAsnltmpTopicConvert INSTANCE = Mappers.getMapper(AlmAsnltmpTopicConvert.class);

    @Mappings({
            @Mapping(target = "askOnlineTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "sendTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "stateBackTime", dateFormat = "yyyy-MM-dd")
    })
    AlmAsnltmpTopicDTO toDTO(AlmAsnltmpTopicRepository almAsnltmpTopicRepository);
    @Mappings({
            @Mapping(target = "askOnlineTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "sendTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "stateBackTime", dateFormat = "yyyy-MM-dd")
    })

    AlmAsnltmpTopicRepository toSYS(AlmAsnltmpTopicDTO almAsnltmpTopicDTO);


    List<AlmAsnltmpTopicDTO> toDTOs(List<AlmAsnltmpTopicRepository> almAsnltmpTopicRepositories);
}
