package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStationFuncRepository;
import com.asiainfo.rms.system.dto.SysStationFuncDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStationFuncConvert {
    SysStationFuncConvert INSTANCE = Mappers.getMapper(SysStationFuncConvert.class);

    SysStationFuncDTO toDTO(SysStationFuncRepository stationFuncRepository);

    SysStationFuncRepository toSYS(SysStationFuncDTO stationFuncDTO);

    List<SysStationFuncDTO> toDTOs(List<SysStationFuncRepository> stationFuncRepositoryList);
}
