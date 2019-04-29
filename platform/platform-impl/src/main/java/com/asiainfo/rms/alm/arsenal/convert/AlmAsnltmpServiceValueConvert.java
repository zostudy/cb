package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceValueRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceValueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpServiceValueConvert {
    AlmAsnltmpServiceValueConvert INSTANCE = Mappers.getMapper(AlmAsnltmpServiceValueConvert.class);

    AlmAsnltmpServiceValueDTO toDTO(AlmAsnltmpServiceValueRepository almAsnltmpServiceValueRepository);

    AlmAsnltmpServiceValueRepository toSYS(AlmAsnltmpServiceValueDTO almAsnltmpServiceValueDTO);

    List<AlmAsnltmpServiceValueDTO> toDTOs(List<AlmAsnltmpServiceValueRepository> almAsnltmpServiceValueRepositoryList);
}
