package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpConfigConvert {
    AlmAsnltmpConfigConvert INSTANCE = Mappers.getMapper(AlmAsnltmpConfigConvert.class);

    AlmAsnltmpConfigDTO toDTO(AlmAsnltmpConfigRepository almAsnltmpConfigRepository);

    AlmAsnltmpConfigRepository toSYS(AlmAsnltmpConfigDTO almAsnltmpConfigDTO);

    List<AlmAsnltmpConfigDTO> toDTOs(List<AlmAsnltmpConfigRepository> almAsnltmpConfigRepository);
}
