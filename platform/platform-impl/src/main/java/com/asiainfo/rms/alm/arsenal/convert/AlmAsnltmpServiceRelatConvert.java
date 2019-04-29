package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceRelatRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceRelatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpServiceRelatConvert {
    AlmAsnltmpServiceRelatConvert INSTANCE = Mappers.getMapper(AlmAsnltmpServiceRelatConvert.class);

    AlmAsnltmpServiceRelatDTO toDTO(AlmAsnltmpServiceRelatRepository almAsnltmpServiceRelatRepository);

    AlmAsnltmpServiceRelatRepository toSYS(AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO);

    List<AlmAsnltmpServiceRelatDTO> toDTOs(List<AlmAsnltmpServiceRelatRepository> asnltmpServiceRelatRepositoryList);
}
