package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStationDataRoleRepository;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStationDataRoleConvert {
    SysStationDataRoleConvert INSTANCE = Mappers.getMapper(SysStationDataRoleConvert.class);

    SysStationDataRoleDTO toDTO(SysStationDataRoleRepository stationDataRoleRepository);

    SysStationDataRoleRepository toSYS(SysStationDataRoleDTO stationDataRoleDTO);

    List<SysStationDataRoleDTO> toDTOs(List<SysStationDataRoleRepository> stationDataRoleRepositoryList);

}
