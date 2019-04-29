package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpOnlineRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpOnlineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpOnlineConvert {
    AlmAsnltmpOnlineConvert INSTANCE = Mappers.getMapper(AlmAsnltmpOnlineConvert.class);
    @Mappings({
            @Mapping(target = "sendTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "stateBackTime", dateFormat = "yyyy-MM-dd")
    })

    AlmAsnltmpOnlineDTO toDTO(AlmAsnltmpOnlineRepository almAsnltmpOnlineRepository);
    @Mappings({
            @Mapping(target = "sendTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "stateBackTime", dateFormat = "yyyy-MM-dd")
    })

    AlmAsnltmpOnlineRepository toSYS(AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO);

    List<AlmAsnltmpOnlineDTO> toDTOs(List<AlmAsnltmpOnlineRepository> almAsnltmpOnlineRepositoryList);
}
