package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpStoreGiveRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpStoreGiveConvert {
    AlmAsnltmpStoreGiveConvert INSTANCE = Mappers.getMapper(AlmAsnltmpStoreGiveConvert.class);
    @Mappings({
            @Mapping(target = "startTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endTime", dateFormat = "yyyy-MM-dd")
    })

    AlmAsnltmpStoreGiveDTO toDTO(AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository);

    @Mappings({
            @Mapping(target = "startTime", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endTime", dateFormat = "yyyy-MM-dd")
    })

    AlmAsnltmpStoreGiveRepository toSYS(AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO);

    List<AlmAsnltmpStoreGiveDTO> toDTOs(List<AlmAsnltmpStoreGiveRepository> almAsnltmpStoreGiveRepositories);
}
