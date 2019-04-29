package com.asiainfo.rms.system.convert;

import com.asiainfo.rms.system.domain.SysStationDataRoleRepository;
import com.asiainfo.rms.system.domain.SysStationWfRoleRepository;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import com.asiainfo.rms.system.dto.SysStationWfRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysStationWfRoleConvert {

    SysStationWfRoleConvert INSTANCE = Mappers.getMapper(SysStationWfRoleConvert.class);

    SysStationWfRoleDTO toDTO(SysStationWfRoleRepository stationWfRoleRepository);

    SysStationWfRoleRepository toSYS(SysStationWfRoleDTO stationWfRoleDTO);

    List<SysStationWfRoleDTO> toDTOs(List<SysStationWfRoleRepository> stationWfRoleRepositoryList);
}
