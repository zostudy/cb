package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStationRepository;
import com.asiainfo.rms.system.dto.SysStationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStationConvert {
    SysStationConvert INSTANCE = Mappers.getMapper(SysStationConvert.class);

    SysStationDTO toDTO(SysStationRepository stationRepository);

    SysStationRepository toSYS(SysStationDTO stationDTO);

    List<SysStationDTO> toDTOs(List<SysStationRepository> stationRepositoryList);

}
